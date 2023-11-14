package christmas.enums;

import christmas.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Date {
    WEEKDAY,
    WEEKEND,
    SPECIAL_DISCOUNT,
    NORMAL_DAY;

    public static final List<Integer> SPECIAL_DISCOUNT_DATES = Arrays.asList(3, 10, 17, 24, 25, 31);


}

