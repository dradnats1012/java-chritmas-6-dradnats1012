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

        for (String menuName : menuNameList) {
            boolean isValid = false;

            isValid = checkAppetizerMenu(menuName, isValid);
            isValid = checkMainMenu(menuName, isValid);
            isValid = checkDessertMenu(menuName, isValid);
            isValid = checkBeverageMenu(menuName, isValid);

            if (!isValid) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }
        }
    }

    private boolean checkAppetizerMenu(String menuName, boolean isValid) {

        for (Appetizer appetizer : Appetizer.values()) {
            if (menuName.equals(appetizer.getName())) {
                menuTypeList.add(appetizer.getIdentifier());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkMainMenu(String menuName, boolean isValid) {

        for (MainMenu mainMenu : MainMenu.values()) {
            if (menuName.equals(mainMenu.getName())) {
                menuTypeList.add(mainMenu.getIdentifier());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkDessertMenu(String menuName, boolean isValid) {

        for (Dessert dessert : Dessert.values()) {
            if (menuName.equals(dessert.getName())) {
                menuTypeList.add(dessert.getIdentifier());
                isValid = true;
                break;
            }
        }

        return isValid;
    }

    private boolean checkBeverageMenu(String menuName, boolean isValid) {

        for (Beverage beverage : Beverage.values()) {
            if (menuName.equals(beverage.getName())) {
                menuTypeList.add(beverage.getIdentifier());
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
}
