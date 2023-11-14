package christmas.model.event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDDayTest {
    @Test
    void 크리스마스_가격_확인() {
        ChristmasDDay christmasDDay = new ChristmasDDay(25);
        ChristmasDDay christmasDDay2 = new ChristmasDDay(3);

        assertEquals(3400, christmasDDay.getSaleMoney());
        assertEquals(1200, christmasDDay2.getSaleMoney());
    }

    @Test
    void 크리스마스_이후_가격_확인(){
        ChristmasDDay christmasDDay = new ChristmasDDay(26);
        assertEquals(0, christmasDDay.getSaleMoney());
    }
}
