package holmes.elliott.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
			break;
		}
		return returnList;
	}

	private List<String> getMenuList() {
		List<String> returnList = new ArrayList<>();
		returnList.addAll(Menu.getInstance().getMenuOptions().entrySet().stream().map(this::convertMenuEntryToString)
				.collect(Collectors.toList()));
		return returnList;
	}

	// This should have been part of Story 2.
	private List<String> getOrderList() {
		List<String> returnList = new ArrayList<>();
		returnList.addAll(currentOrder.getOrderItems().entrySet().stream().map(this::convertOrderEntryToString)
				.collect(Collectors.toList()));
		returnList.addAll(getOrderTotals());
		return returnList;

	}

	private List<String> getOrderTotals() {
		OrderController orderController = new OrderController(currentOrder);
		StringBuilder strBuilder = new StringBuilder();
		List<String> returnList = new ArrayList<>();
		strBuilder.append(Constants.ORDER_SUBTOTAL);
		strBuilder.append(orderController.getOrderSubTotal().toString());
		returnList.add(strBuilder.toString());
		strBuilder.delete(0, strBuilder.length());
		strBuilder.append(Constants.ORDER_SERVICE_CHARGE);
		strBuilder.append(orderController.getOrderServiceCharge().toString());
		returnList.add(strBuilder.toString());
		strBuilder.delete(0, strBuilder.length());
		strBuilder.append(Constants.ORDER_TOTAL);
		strBuilder.append(orderController.getOrderTotal().toString());
		returnList.add(strBuilder.toString());
		return returnList;
	}

	private boolean addToOrder(String command) {
		if (Menu.getInstance().getMenuOptions().containsKey(command)) {
			MenuItem item = Menu.getInstance().getMenuOptions().get(command);
			currentOrder.addItemToOrder(++currentId, item);
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

	private String convertOrderEntryToString(Entry<Integer, MenuItem> itemEntry) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(itemEntry.getKey());
		strBuilder.append("\t");
		strBuilder.append(itemEntry.getValue().getProductDescription());
		strBuilder.append(" (£");
		strBuilder.append(itemEntry.getValue().getProductPrice().toPlainString());
		strBuilder.append(")");
		return strBuilder.toString();
	}

	private String convertMenuEntryToString(Entry<String, MenuItem> itemEntry) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(itemEntry.getKey());
		strBuilder.append("\t");
		strBuilder.append(itemEntry.getValue().getProductDescription());
		strBuilder.append(" (£");
		strBuilder.append(itemEntry.getValue().getProductPrice().toPlainString());
		strBuilder.append(")");
		return strBuilder.toString();
	}

}
