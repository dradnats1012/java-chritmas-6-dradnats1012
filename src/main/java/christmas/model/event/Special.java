package christmas.model.event;

import static christmas.enums.Date.SPECIAL_DISCOUNT_DATES;

public class Special {

    private final int date;
    private static final int specialDiscountMoney = 1000;
    private int saleMoney = 0;

    public Special(int date) {
        this.date = date;
        plusSpecialDiscount();
    }

    private void plusSpecialDiscount() {
        if (checkSpecialDiscountDate()) {
            saleMoney += specialDiscountMoney;
        }
    }

    private boolean checkSpecialDiscountDate() {

        for (int specialDate : SPECIAL_DISCOUNT_DATES) {
            if (date == specialDate) {
                return true;
            }
        }

        return false;
    }

    public int getSaleMoney() {

        return saleMoney;
    }
}
