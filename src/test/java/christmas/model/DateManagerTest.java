package christmas.model;

import christmas.enums.Date;
import christmas.model.event.Badge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateManagerTest {


    @Test
    void 주말_확인() {
        DateManager dateManager = new DateManager(1);

        assertEquals(Date.WEEKEND, dateManager.getDayType());
    }

    @Test
    void 평일_확인() {
        DateManager dateManager = new DateManager(4);

        assertEquals(Date.WEEKDAY, dateManager.getDayType());
    }

    @Test
    void 특별할인날_확인() {
        DateManager dateManager = new DateManager(3);

        assertEquals(Date.SPECIAL_DISCOUNT, dateManager.getDayType());
    }

    @Test
    void 크리스마스_확인() {
        DateManager dateManager = new DateManager(25);

        assertEquals(Date.SPECIAL_DISCOUNT, dateManager.getDayType());
    }
}
