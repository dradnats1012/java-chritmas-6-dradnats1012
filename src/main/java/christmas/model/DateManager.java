package christmas.model;

import christmas.enums.Date;
import christmas.message.ErrorMessage;

import static christmas.enums.Date.*;

public class DateManager {

    private final int date;

    public DateManager(int date) {
        this.date = date;
        throwUnvalidDateException();
    }

    public Date getDayType() {

        if (checkSpecialDiscountDate(date)) {
            return SPECIAL_DISCOUNT;
        }
        if (date % 7 == 1 || date % 7 == 2) {
            return WEEKEND;
        }

        return WEEKDAY;
    }

    private void throwUnvalidDateException() {

        if (checkValidateDate(date)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_DATE.getMessage());
        }
    }

    private static boolean checkValidateDate(int date) {

        return date < 1 || date > 31;
    }

    private static boolean checkSpecialDiscountDate(int day) {

        for (int specialDate : SPECIAL_DISCOUNT_DATES) {
            if (day == specialDate) {
                return true;
            }
        }

        return false;
    }
}
