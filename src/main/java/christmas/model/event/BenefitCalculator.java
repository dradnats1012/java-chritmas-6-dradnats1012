package christmas.model.event;

import christmas.model.DateManager;

import java.util.List;

import static christmas.enums.Date.*;

public class BenefitCalculator {
    private int benefitMoney = 0;
    private final int totalMoney;

    private final ChristmasDDay christmasDDay;
    private final Giveaway giveaway;
    private final Special special;
    private final DateManager dateManager;
    private final WeekDay weekDay;
    private final Weekend weekend;

    public BenefitCalculator(int date, int totalMoney, List<Integer> menuTypeList){
        this.totalMoney = totalMoney;

        christmasDDay = new ChristmasDDay(date);
        giveaway = new Giveaway(totalMoney);
        special = new Special(date);
        dateManager = new DateManager(date);
        weekDay = new WeekDay(menuTypeList);
        weekend = new Weekend(menuTypeList);

        checkSaleCondition();
    }

    private boolean checkOver10000(){
        return totalMoney >= 10000;
    }

    private void checkSaleCondition(){
        if(checkOver10000()){
            calculateBenefitMoney();
        }
    }
    private void calculateBenefitMoney(){
        benefitMoney += christmasDDay.getSaleMoney();
        benefitMoney += giveaway.getBenefitMoney();
        benefitMoney += special.getSaleMoney();

        if(dateManager.getDayType() == WEEKEND){
            benefitMoney += weekend.getSaleMoney();
        }
        if(dateManager.getDayType() == WEEKDAY || dateManager.getDayType() == SPECIAL_DISCOUNT){
            benefitMoney += weekDay.getSaleMoney();
        }
    }

    public int getBenefitMoney(){
        return benefitMoney;
    }
}
