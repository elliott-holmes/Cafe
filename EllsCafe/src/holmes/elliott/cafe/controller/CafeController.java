package holmes.elliott.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import holmes.elliott.cafe.helper.Constants;
import holmes.elliott.cafe.model.Menu;
import holmes.elliott.cafe.model.MenuItem;
import holmes.elliott.cafe.model.Order;

public class CafeController {

	private Order currentOrder = new Order();
	private Integer currentId = new Integer(0);

	public List<String> handleRequest(String command) {
		List<String> returnList = null;
		switch (command) {
		case Constants.LIST_MENU:
			returnList = getMenuList();
			break;
		case Constants.LIST_ORDER:
			returnList = getOrderList();
			break;
		case Constants.NEW_ORDER:
			newOrder();
			break;
		default:
			if (!addToOrder(command)) {
				returnList = new ArrayList<>();
				returnList.add("Unable to add Item " + command + " to order. please check ");
			}
			;
			break;
		}
		return returnList;
	}

	private List<String> getMenuList() {
		List<String> returnList = new ArrayList<>();
		StringBuilder strBuilder = new StringBuilder();
		for (String key : Menu.getInstance().getMenuOptions().keySet()) {
			MenuItem item = Menu.getInstance().getMenuOptions().get(key);
			strBuilder.append(key);
			strBuilder.append("\t");
			strBuilder.append(item.getProductDescription());
			strBuilder.append(" (£");
			strBuilder.append(item.getProductPrice().toPlainString());
			strBuilder.append(")");
			returnList.add(strBuilder.toString());
			strBuilder.delete(0, strBuilder.length());
		}
		return returnList;
	}

	private List<String> getOrderList() {
		List<String> returnList = new ArrayList<>();
		StringBuilder strBuilder = new StringBuilder();
		for (Integer key : currentOrder.getOrderItems().keySet()) {
			MenuItem item = currentOrder.getOrderItems().get(key);
			strBuilder.append(key);
			strBuilder.append("\t");
			strBuilder.append(item.getProductDescription());
			strBuilder.append(" (£");
			strBuilder.append(item.getProductPrice().toPlainString());
			strBuilder.append(")");
			returnList.add(strBuilder.toString());
			strBuilder.delete(0, strBuilder.length());
		}
		strBuilder.append(Constants.ORDER_TOTAL);
		strBuilder.append("\t£");
		strBuilder.append(currentOrder.getOrderTotal().toString());
		returnList.add(strBuilder.toString());
		return returnList;

	}

	private boolean addToOrder(String command) {
		if (Menu.getInstance().getMenuOptions().containsKey(command)) {
			MenuItem item = Menu.getInstance().getMenuOptions().get(command);
			currentOrder.addItemToOrder(currentId++, item);
			return true;
		}
		return false;

	}

	private void newOrder() {
		currentOrder = new Order();
		return;
	}

	public Order getOrder() {
		return currentOrder;
	}

}
