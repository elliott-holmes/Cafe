package holmes.elliott.cafe.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.helper.StartUp;
import holmes.elliott.cafe.model.MenuItem;
import holmes.elliott.cafe.model.Order;

public class OrderTest {

	private Order testOrder;

	@Before
	public void setUp() throws Exception {
		testOrder = new Order();
		testOrder.addItemToOrder(1, new MenuItem("test1", new BigDecimal("10"), MenuItem.Type.COLD_DRINK));
		testOrder.addItemToOrder(2, new MenuItem("test2", new BigDecimal("20.1"), MenuItem.Type.COLD_FOOD));
		testOrder.addItemToOrder(3, new MenuItem("test1", new BigDecimal("30.20"), MenuItem.Type.HOT_DRINK));
		StartUp.populateMenu();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrderItems() {
		assertNotNull(testOrder.getOrderItems());
	}

	@Test
	public void testAddItemToOrder() {
		int currentSize = testOrder.getOrderItems().size();
		testOrder.addItemToOrder(4, new MenuItem());
		testOrder.addItemToOrder(5, new MenuItem());
		testOrder.addItemToOrder(6, new MenuItem());
		assertEquals(testOrder.getOrderItems().size(), currentSize + 3);
	}

	@Test
	public void testRemoveItemFromOrder() {
		int currentSize = testOrder.getOrderItems().size();
		testOrder.removeItemFromOrder(1);
		assertEquals(testOrder.getOrderItems().size(), currentSize - 1);
		// this should not be in the order so should not remove anything
		testOrder.removeItemFromOrder(5);
		assertEquals(testOrder.getOrderItems().size(), currentSize - 1);

	}

}
