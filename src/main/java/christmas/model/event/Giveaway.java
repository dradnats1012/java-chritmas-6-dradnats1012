package christmas.model.event;

public class Giveaway {

    private final int totalMoney;
    private int benefitMoney = 0;
    private static final int LOWER_LIMIT_PRICE = 120000;

    public Giveaway(int totalMoney){
        this.totalMoney = totalMoney;
        calculateBenefitMoney();
    }

    private void calculateBenefitMoney(){

        if(checkGiveaway()){
            benefitMoney += 25000;
        }
    }

    public boolean checkGiveaway(){

        return totalMoney >= LOWER_LIMIT_PRICE;
    }

    public int getBenefitMoney(){

        return benefitMoney;
    }
}
