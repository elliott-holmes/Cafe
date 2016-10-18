package holmes.elliott.cafe.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.helper.StartUp;
import holmes.elliott.cafe.model.Menu;

public class StartUpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPopulateMenu() {

		Menu menu = Menu.getInstance();
		StartUp.populateMenu();
		assertEquals(Menu.getInstance().getMenuOptions().size(), 4);
		assertEquals(menu, Menu.getInstance());
	}

}
