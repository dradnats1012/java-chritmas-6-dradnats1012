package christmas.model.order;

import christmas.enums.Appetizer;
import christmas.enums.Beverage;
import christmas.enums.Dessert;
import christmas.enums.MainMenu;
import christmas.message.ErrorMessage;

import java.util.*;

public class TakeOrder {
    private final List<Map<String, Integer>> menuList;
    private final List<String> menuNameList = new ArrayList<>();
    private final List<Integer> menuCountList = new ArrayList<>();
    private final List<Integer> menuTypeList = new ArrayList<>();
    private final List<Integer> menuPriceList = new ArrayList<>();

    public TakeOrder(List<Map<String, Integer>> menuList) {
        this.menuList = menuList;
        makeMenuList();
        checkMenuQuantity();
        isValidMenu();
        checkOnlyBeverage();
        checkDuplicateMenu();
    }

    private void makeMenuList() {

        for (Map<String, Integer> menu : menuList) {

            for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                menuNameList.add(entry.getKey());
                menuCountList.add(entry.getValue());
            }
        }
    }

    private void checkMenuQuantity() {

        int total = countMenuQuantity();
        if (total > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private int countMenuQuantity() {

        int sum = 0;
        for (int menuCount : menuCountList) {
            if (menuCount == 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }
            sum += menuCount;
        }

        return sum;
    }

    private void isValidMenu() {

        for (Map<String, Integer> menu : menuList) {
            boolean isValid = false;

            for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                String name = entry.getKey();
                int count = entry.getValue();

                isValid = checkAppetizerMenu(name, count, isValid);
                isValid = checkMainMenu(name, count, isValid);
                isValid = checkDessertMenu(name, count, isValid);
                isValid = checkBeverageMenu(name, count, isValid);

                if (!isValid) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
                }
            }


        }
    }

    private boolean checkAppetizerMenu(String menuName, int count, boolean isValid) {

        for (Appetizer appetizer : Appetizer.values()) {
            if (menuName.equals(appetizer.getName())) {
                for (int i = 0; i < count; i++) {
                    menuTypeList.add(appetizer.getIdentifier());
                }
                menuPriceList.add(appetizer.getPrice());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkMainMenu(String menuName, int count, boolean isValid) {

        for (MainMenu mainMenu : MainMenu.values()) {
            if (menuName.equals(mainMenu.getName())) {
                for (int i = 0; i < count; i++) {
                    menuTypeList.add(mainMenu.getIdentifier());
                }
                menuPriceList.add(mainMenu.getPrice());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkDessertMenu(String menuName, int count, boolean isValid) {

        for (Dessert dessert : Dessert.values()) {
            if (menuName.equals(dessert.getName())) {
                for (int i = 0; i < count; i++) {
                    menuTypeList.add(dessert.getIdentifier());
                }
                menuPriceList.add(dessert.getPrice());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkBeverageMenu(String menuName, int count, boolean isValid) {

        for (Beverage beverage : Beverage.values()) {
            if (menuName.equals(beverage.getName())) {
                for (int i = 0; i < count; i++) {
                    menuTypeList.add(beverage.getIdentifier());
                }
                menuPriceList.add(beverage.getPrice());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private void checkOnlyBeverage() {

        if (menuTypeList.size() == 1 && menuTypeList.contains(4)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private void checkDuplicateMenu() {
        Set<String> duplicateCheckSet = new HashSet<>(menuNameList);

        if (duplicateCheckSet.size() != menuNameList.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public List<Integer> getMenuTypeList() {

        return menuTypeList;
    }

    public List<Integer> getMenuPriceList() {

        return menuPriceList;
    }

    public List<Integer> getMenuCountList() {

        return menuCountList;
    }
}
