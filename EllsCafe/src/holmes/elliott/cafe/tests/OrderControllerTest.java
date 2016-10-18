package holmes.elliott.cafe.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.controller.OrderController;
import holmes.elliott.cafe.model.MenuItem;
import holmes.elliott.cafe.model.Order;

public class OrderControllerTest {

	OrderController controller;

	@Before
	public void setUp() throws Exception {
		Order testOrder = new Order();
		testOrder.addItemToOrder(1, new MenuItem("test1", new BigDecimal("10"), MenuItem.Type.COLD_DRINK));
		testOrder.addItemToOrder(2, new MenuItem("test2", new BigDecimal("20.1"), MenuItem.Type.HOT_DRINK));
		testOrder.addItemToOrder(3, new MenuItem("test1", new BigDecimal("30.20"), MenuItem.Type.COLD_FOOD));
		controller = new OrderController(testOrder);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrderSubTotal() {
		assertEquals(new BigDecimal("60.30"), controller.getOrderSubTotal());
		Order order = controller.getOrder();
		order.addItemToOrder(4, new MenuItem("test1", new BigDecimal("15.44"), MenuItem.Type.HOT_FOOD));
		controller.reset();
		assertEquals(new BigDecimal("75.74"), controller.getOrderSubTotal());
	}

	@Test
	public void testGetOrderServiceCharge() {
		assertEquals(new BigDecimal("6.03"), controller.getOrderServiceCharge());
		Order order = controller.getOrder();
		MenuItem newItem = new MenuItem("test1", new BigDecimal("15.44"), MenuItem.Type.HOT_FOOD);
		order.addItemToOrder(4, newItem);
		controller.reset();
		assertEquals(new BigDecimal("15.15"), controller.getOrderServiceCharge());

	}

	@Test
	public void testGetOrderTotal() {
		assertEquals(new BigDecimal("66.33"), controller.getOrderTotal());
		Order order = controller.getOrder();
		MenuItem newItem = new MenuItem("test1", new BigDecimal("15.44"), MenuItem.Type.HOT_FOOD);
		order.addItemToOrder(4, newItem);
		controller.reset();
		assertEquals(new BigDecimal("90.89"), controller.getOrderTotal());
	}

	@Test
	public void testMaximumServiceCharge(){
		Order testOrder = new Order();
		testOrder.addItemToOrder(1, new MenuItem("test1", new BigDecimal("100"), MenuItem.Type.HOT_FOOD));
		controller = new OrderController(testOrder);
		assertEquals(new BigDecimal("20.00"), controller.getOrderServiceCharge());
		MenuItem newItem = new MenuItem("test99", new BigDecimal("44.44"), MenuItem.Type.HOT_FOOD);
		controller.getOrder().addItemToOrder(4, newItem);
		controller.reset();
		assertEquals(new BigDecimal("20.00"), controller.getOrderServiceCharge());
	}
}
