package holmes.elliott.cafe.tests;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		testOrder.addItemToOrder(1, new MenuItem("test1", new BigDecimal("10")));
		testOrder.addItemToOrder(2, new MenuItem("test2", new BigDecimal("20.1")));
		testOrder.addItemToOrder(3, new MenuItem("test1", new BigDecimal("30.20")));
		controller = new OrderController(testOrder);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrderSubTotal() {
		assertEquals(new BigDecimal("60.30"), controller.getOrderSubTotal());
		Order order = controller.getOrder();
		order.addItemToOrder(4, new MenuItem("test1", new BigDecimal("44.44")));
		controller.reset();		
		assertEquals(new BigDecimal("104.74"), controller.getOrderSubTotal());		
	}

	@Test
	public void testGetOrderServiceCharge() {
		assertEquals(new BigDecimal("6.03"), controller.getOrderServiceCharge());
		Order order = controller.getOrder();
		order.addItemToOrder(4, new MenuItem("test1", new BigDecimal("44.44")));
		controller.reset();		
		assertEquals(new BigDecimal("10.48"), controller.getOrderServiceCharge());		

	}

	@Test
	public void testGetOrderTotal() {
		assertEquals(new BigDecimal("66.33"), controller.getOrderTotal());
		Order order = controller.getOrder();
		order.addItemToOrder(4, new MenuItem("test1", new BigDecimal("44.44")));
		controller.reset();		
		assertEquals(new BigDecimal("115.22"), controller.getOrderTotal());		
	}

}
