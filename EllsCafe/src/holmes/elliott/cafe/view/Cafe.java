package holmes.elliott.cafe.view;

import java.util.List;
import java.util.Scanner;

import holmes.elliott.cafe.controller.CafeController;
import holmes.elliott.cafe.helper.Constants;
import holmes.elliott.cafe.helper.StartUp;

public class Cafe {

	public static void main(String[] args) {
		// populate list of menu Items
		StartUp.populateMenu();
		CafeController controller = new CafeController();

		showDetails(controller.handleRequest(Constants.LIST_MENU));
		String command = new String("");
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(
					"Please enter next item to add, L to list order, N for new order, M for Menu or X to exit :-");
			command = in.nextLine().toUpperCase();
			if (command.equals(Constants.EXIT)) {
				in.close();
				break;
			}
			showDetails(controller.handleRequest(command));
		}

	}

	private static void showDetails(List<String> details) {
		if (details != null) {
			details.stream().forEach(System.out::println);
		}
	}

}
