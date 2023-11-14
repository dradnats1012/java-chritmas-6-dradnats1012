package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.message.ConsoleMessage;
import christmas.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {

    public int inputDate() {

        System.out.println(ConsoleMessage.WELCOME_EVENT_PLANNER);
        System.out.println(ConsoleMessage.EXPECTED_VISIT_DATE.getMessage());
        String input = Console.readLine();
        int date;

        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_DATE.getMessage());
        }

        return date;
    }

    public List<Map<String, Integer>> inputMenu() {

        System.out.println(ConsoleMessage.MENU_NAME_QUANTITY.getMessage());

        String menu = Console.readLine();
        String[] menus = menu.split(",");
        List<Map<String, Integer>> menuList = new ArrayList<>();

        for (String menuPair : menus) {
            String[] menuPairSplit = menuPair.split("-");
            Map<String, Integer> menuMap = new HashMap<>();

            try {
                menuMap.put(menuPairSplit[0], Integer.parseInt(menuPairSplit[1]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }catch (ArrayIndexOutOfBoundsException e){
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }

            menuList.add(menuMap);
        }

        return menuList;
    }
}
