package holmes.elliott.cafe.helper;

import java.math.BigDecimal;
import java.util.HashMap;

import holmes.elliott.cafe.model.Menu;
import holmes.elliott.cafe.model.MenuItem;

public class StartUp {
	public static void populateMenu() {
		Menu menu = Menu.getInstance();
		menu.setMenuOptions(new HashMap<>());
		MenuItem cola = new MenuItem("Cola - Cold Drink", new BigDecimal("0.50"));
		MenuItem coffee = new MenuItem("Coffee - Hot Drink", new BigDecimal("1.00"));
		MenuItem cheese_sandwich = new MenuItem("Cheese Sandwich - Cold food", new BigDecimal("2.00"));
		MenuItem steak_sandwich = new MenuItem("Steak Sandwich - Hot food", new BigDecimal("4.50"));
		menu.addMenuOption("1", cola);
		menu.addMenuOption("2", coffee);
		menu.addMenuOption("3", cheese_sandwich);
		menu.addMenuOption("4", steak_sandwich);
	}
}
