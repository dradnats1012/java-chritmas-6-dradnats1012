package christmas.model.event;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekendTest {
    @Test
    void 메인_3개(){
        List<Integer> menuTypeList = Arrays.asList(1,1,2,2,2,3);
        Weekend weekend = new Weekend(menuTypeList);

        assertEquals(6069, weekend.getSaleMoney());
    }

    @Test
    void 메인_0개(){
        List<Integer> menuTypeList = Arrays.asList(1,1,3);
        Weekend weekend = new Weekend(menuTypeList);

        assertEquals(0, weekend.getSaleMoney());
    }
}
