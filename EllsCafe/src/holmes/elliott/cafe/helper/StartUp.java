package holmes.elliott.cafe.helper;

import java.math.BigDecimal;
import java.util.HashMap;

import holmes.elliott.cafe.model.Menu;
import holmes.elliott.cafe.model.MenuItem;

public class StartUp {
	public static void populateMenu() {
		Menu menu = Menu.getInstance();
		menu.setMenuOptions(new HashMap<>());
		MenuItem cola = new MenuItem("Cola", new BigDecimal("0.50"), MenuItem.Type.COLD_DRINK);
		MenuItem coffee = new MenuItem("Coffee", new BigDecimal("1.00"), MenuItem.Type.HOT_DRINK);
		MenuItem cheese_sandwich = new MenuItem("Cheese Sandwich", new BigDecimal("2.00"), MenuItem.Type.COLD_FOOD);
		MenuItem steak_sandwich = new MenuItem("Steak Sandwich", new BigDecimal("4.50"), MenuItem.Type.HOT_FOOD);
		menu.addMenuOption("1", cola);
		menu.addMenuOption("2", coffee);
		menu.addMenuOption("3", cheese_sandwich);
		menu.addMenuOption("4", steak_sandwich);
	}
}
