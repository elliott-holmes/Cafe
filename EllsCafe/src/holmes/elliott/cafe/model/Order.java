package holmes.elliott.cafe.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

	public void removeItemFromOrder(Integer itemKey) {
		getOrderItems().remove(itemKey);
	}
	
	public BigDecimal getOrderTotal(){
		BigDecimal total = BigDecimal.ZERO;
		for (Entry<Integer, MenuItem> item : getOrderItems().entrySet()) {
			total = total.add(item.getValue().getProductPrice());
		}
		return total;
	}
}
