package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.model.DateManager;
import christmas.model.event.Badge;
import christmas.model.event.BenefitCalculator;
import christmas.model.event.Giveaway;
import christmas.model.order.OrderCalculator;
import christmas.model.order.TakeOrder;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        int date = getDate();
        List<Map<String,Integer>> menuList = getMenu();

        TakeOrder takeOrder = new TakeOrder(menuList);
        List<Integer> menuTypeList = takeOrder.getMenuTypeList();
        OrderCalculator orderCalculator = new OrderCalculator(takeOrder);
        outputView.printOrderMenu(menuList, date);

        int totalPrice = orderCalculator.calculateTotalMoney();
        Giveaway giveaway = new Giveaway(totalPrice);
        BenefitCalculator benefitCalculator = new BenefitCalculator(date, totalPrice, menuTypeList);

        outputView.printTotalPrice(totalPrice);
        outputView.printGiveAway(giveaway.checkGiveaway());

        outputView.printTotalBenefits(benefitCalculator.getBenefitList());

        int benefitPrice = benefitCalculator.getBenefitMoney();
        outputView.printTotalBenefitsMoney(benefitPrice);

        int afterBenefitPrice = totalPrice - benefitCalculator.getRealBenefitMoney();
        outputView.printTotalAfterBenefit(afterBenefitPrice);

        Badge badge = new Badge(benefitPrice);
        outputView.printBadge(badge.selectEventBadge());
    }

    private int getDate(){
        int date = 0;

        try{
            date = inputView.inputDate();
            DateManager dateManager = new DateManager(date);
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.OUT_OF_RANGE_DATE.getMessage());
            getDate();
        }

        return date;
    }

    private List<Map<String, Integer>> getMenu(){
        List<Map<String, Integer>> menu = new ArrayList<>();

        try{
            menu = inputView.inputMenu();
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.INVALID_ORDER.getMessage());
            getMenu();
        }

        return menu;
    }
}
