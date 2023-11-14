package christmas.model.event;

import christmas.message.ConsoleMessage;
import christmas.model.DateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.enums.Date.*;

public class BenefitCalculator {
    private int benefitMoney = 0;
    private final int totalMoney;

    private final List<Map<String, Integer>> benefitList = new ArrayList<>();
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
        makeBenefitList();
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

    private void makeBenefitList() {

        if (christmasDDay.getSaleMoney() != 0) {
            benefitList.add(Map.of(ConsoleMessage.CHRISTMAS_D_DAY_SALE.getMessage(), christmasDDay.getSaleMoney()));
        }
        if (dateManager.getDayType() == WEEKEND && weekend.getSaleMoney() != 0) {
            benefitList.add(Map.of(ConsoleMessage.WEEKEND_SALE.getMessage(), weekend.getSaleMoney()));
        }
        if(special.getSaleMoney() != 0){
            benefitList.add(Map.of(ConsoleMessage.WEEKDAY_SALE.getMessage(), weekDay.getSaleMoney()));
            benefitList.add(Map.of(ConsoleMessage.SPECIAL_SALE.getMessage(), special.getSaleMoney()));
        }
        if(giveaway.getBenefitMoney() != 0){
            benefitList.add(Map.of(ConsoleMessage.GIVEAWAY_EVENT.getMessage(), giveaway.getBenefitMoney()));
        }
    }

    public List<Map<String, Integer>> getBenefitList(){

        return benefitList;
    }
    public int getBenefitMoney(){

        return benefitMoney;
    }

    public int getRealBenefitMoney(){

        if(giveaway.getBenefitMoney() != 0){
            return benefitMoney - 25000;
        }
        return benefitMoney;
    }
}
