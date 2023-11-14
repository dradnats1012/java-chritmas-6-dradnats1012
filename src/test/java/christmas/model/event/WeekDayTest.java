package christmas.model.event;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayTest {
    @Test
    void 디저트_3개(){
        List<Integer> menuTypeList = Arrays.asList(1,1,2,3,3,3);
        WeekDay weekDay = new WeekDay(menuTypeList);

        assertEquals(6069, weekDay.getSaleMoney());
    }

    @Test
    void 디저트_0개(){
        List<Integer> menuTypeList = Arrays.asList(1,1,2);
        WeekDay weekDay = new WeekDay(menuTypeList);

        assertEquals(0, weekDay.getSaleMoney());
    }
}
