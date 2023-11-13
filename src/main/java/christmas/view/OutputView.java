package christmas.view;

import christmas.message.ConsoleMessage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public void printOrderMenu(List<Map<String, Integer>> menuList) {

        System.out.println(ConsoleMessage.ORDER_MENU);

        for (Map<String, Integer> menuPair : menuList) {
            printMenuPair(menuPair);
        }
    }

    private void printMenuPair(Map<String, Integer> menuPair) {

        for (Entry<String, Integer> entry : menuPair.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(menuName + " " + quantity + "개");
        }
    }

    public void printTotalPrice(int totalPrice) {

        System.out.println(ConsoleMessage.TOTAL_PRICE.getMessage());
        System.out.println(formatPrice(totalPrice));
    }

    private String formatPrice(int price) {

        return String.format("%,d원", price);
    }

    public void printGiveAway(boolean isGiveaway) {

        System.out.println(ConsoleMessage.GIVEAWAY_MENU.getMessage());

        if (isGiveaway) {
            System.out.println(ConsoleMessage.CHAMPAGNE.getMessage());
            return;
        }

        System.out.println(ConsoleMessage.NOTHING.getMessage());
    }

    public void printTotalBenefitsMoney(int totalBenefitsMoney) {

        System.out.println(ConsoleMessage.TOTAL_BENEFITS_PRICE.getMessage());

        if (totalBenefitsMoney == 0) {
            System.out.println("0원");
            return;
        }

        System.out.printf(ConsoleMessage.BENEFITS_MONEY.getMessage(), formatPrice(totalBenefitsMoney));
    }

    public void printTotalBenefits(List<Map<String, Integer>> benefitList) {

        System.out.println(ConsoleMessage.BENEFIT_DETAILS.getMessage());

        for (Map<String, Integer> benefitPair : benefitList) {
            printBenefitPair(benefitPair);
        }
    }

    private void printBenefitPair(Map<String, Integer> benefitPair) {

        for (Entry<String, Integer> entry : benefitPair.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf(menuName, formatPrice(quantity));
        }
    }

    public void printTotalAfterBenefit(int totalAfterBenefit) {

        System.out.println(ConsoleMessage.PRICE_AFTER_SALE.getMessage());
        System.out.println(formatPrice(totalAfterBenefit));
    }

    public void printBadge(String badge) {
        System.out.println(ConsoleMessage.EVENT_BADGE.getMessage());
        System.out.println(badge);
    }
}
