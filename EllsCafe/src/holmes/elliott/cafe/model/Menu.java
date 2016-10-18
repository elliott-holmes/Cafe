package holmes.elliott.cafe.model;

import java.util.HashMap;

public class Menu {
	private static Menu INSTANCE = new Menu();
	private HashMap<String, MenuItem> menuOptions;
	
	private Menu(){
		//private Constructor to prevent external instantiation
	}

	public static Menu getInstance(){
		return INSTANCE;
	}
	
	public HashMap<String, MenuItem> getMenuOptions() {
		if (menuOptions == null) {
			menuOptions = new HashMap<>();
		}
		return menuOptions;
	}

	public void addMenuOption(String key, MenuItem menuItem){
		getMenuOptions().put(key, menuItem);
	}
	
	public void setMenuOptions(HashMap<String, MenuItem> menuOptions) {
		this.menuOptions = menuOptions;
	}

}
