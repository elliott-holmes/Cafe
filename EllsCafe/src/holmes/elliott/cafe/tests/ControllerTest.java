package holmes.elliott.cafe.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.controller.CafeController;
import holmes.elliott.cafe.helper.StartUp;

public class ControllerTest {

	private CafeController controller;

	@Before
	public void setUp() throws Exception {
		StartUp.populateMenu();
		controller = new CafeController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHandleRequest() {
		assertNotNull(controller.handleRequest("M"));
		assertEquals(controller.handleRequest("M").size(), 4);
		assertNull(controller.handleRequest("1"));
		assertNull(controller.handleRequest("2"));
		assertNull(controller.handleRequest("3"));
		assertNotNull(controller.handleRequest("L"));
		assertEquals(controller.getOrder().getOrderItems().entrySet().size(), 3);
		// List order should be order size + total line
		assertEquals(controller.handleRequest("L").size(), 6);
		controller.handleRequest("N");
		assertEquals(controller.getOrder().getOrderItems().entrySet().size(), 0);

	}

}
