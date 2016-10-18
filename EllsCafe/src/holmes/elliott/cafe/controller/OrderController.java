package holmes.elliott.cafe.controller;

import java.math.BigDecimal;
import java.util.Map.Entry;

import holmes.elliott.cafe.model.MenuItem;
import holmes.elliott.cafe.model.Order;

/**
 * 
 * @author holmese New class to handle the business Logic on an order, otherwise
 *         to much logic is happening in the object.
 */
public class OrderController {
	private Order currentOrder;
	BigDecimal subTotal;
	BigDecimal serviceCharge;
	BigDecimal orderTotal;

	BigDecimal serviceChargePercentage;

	public OrderController(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public void reset() {
		subTotal = null;
		serviceCharge = null;
		orderTotal = null;
	}

	// This should have been part of Story 2.
	public BigDecimal getOrderSubTotal() {
		if (subTotal == null) {
			subTotal = BigDecimal.ZERO;
			for (Entry<Integer, MenuItem> item : currentOrder.getOrderItems().entrySet()) {
				subTotal = subTotal.add(item.getValue().getProductPrice());
			}
		}
		return subTotal;
	}

	public BigDecimal getOrderServiceCharge() {
		if (serviceCharge == null) {
			serviceCharge = getOrderSubTotal().multiply(getServiceChargePercentage());
			serviceCharge = serviceCharge.setScale(2, BigDecimal.ROUND_UP);
		}
		return serviceCharge;
	}

	public BigDecimal getOrderTotal() {
		if (orderTotal == null) {
			orderTotal = getOrderSubTotal().add(getOrderServiceCharge());
		}
		return orderTotal;
	}

	public Order getOrder() {
		return currentOrder;
	}

	private BigDecimal getServiceChargePercentage() {
		serviceChargePercentage = new BigDecimal("0.1");
		if (currentOrder.getOrderItems().values().stream()
				.filter(item -> item.getProductType().equals(MenuItem.Type.HOT_FOOD)).findFirst()
				.orElse(null) != null) {
			serviceChargePercentage = new BigDecimal("0.2");
		}
		return serviceChargePercentage;
	}
}
