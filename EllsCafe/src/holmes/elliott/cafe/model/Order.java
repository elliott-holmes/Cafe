package holmes.elliott.cafe.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

	private Map<Integer, MenuItem> orderItems;
	private String orderId;

	public Order() {

	}

	public Map<Integer, MenuItem> getOrderItems() {
		if (orderItems == null) {
			orderItems = new HashMap<>();
		}
		return orderItems;
	}

	public void setOrderItems(HashMap<Integer, MenuItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void addItemToOrder(Integer itemKey, MenuItem item) {
		getOrderItems().put(itemKey, item);
	}

	/**
	 * Method not implemented
	 * @param itemKey
	 */
	public void removeItemFromOrder(Integer itemKey) {
		getOrderItems().remove(itemKey);
	}

}
