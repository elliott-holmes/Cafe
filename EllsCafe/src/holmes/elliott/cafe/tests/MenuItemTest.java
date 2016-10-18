package holmes.elliott.cafe.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.model.MenuItem;

public class MenuItemTest {

	private String testDescription = "Test Description";
	private BigDecimal testPrice = new BigDecimal("25.00");
	private MenuItem.Type testType = MenuItem.Type.COLD_DRINK;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMenuItemStringBigDecimal() {
		MenuItem item = new MenuItem(testDescription, testPrice, testType);
		assertEquals(item.getProductDescription(), testDescription);
		assertEquals(item.getProductPrice(), new BigDecimal("25.00"));
	}

}
