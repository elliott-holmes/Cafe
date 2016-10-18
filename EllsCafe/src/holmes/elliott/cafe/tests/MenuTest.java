package holmes.elliott.cafe.tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import holmes.elliott.cafe.helper.StartUp;
import holmes.elliott.cafe.model.Menu;

public class MenuTest {

	@Before
	public void setUp() throws Exception {
		Menu.getInstance().setMenuOptions(new HashMap<>());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		Menu menu = Menu.getInstance();
		Menu menu2 = Menu.getInstance();
		assertEquals(menu, menu2);
	}

	@Test
	public void testGetMenuOptions() {
		assertNotNull(Menu.getInstance().getMenuOptions());
		assertEquals(Menu.getInstance().getMenuOptions().size(),0);
		StartUp.populateMenu();
		assertNotNull(Menu.getInstance().getMenuOptions());
		assertEquals(Menu.getInstance().getMenuOptions().size(),4);
		
	}

}
