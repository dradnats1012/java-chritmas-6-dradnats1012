package christmas.model.event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialTest {
    @Test
    void 일요일_주문() {
        Special special = new Special(3);

        assertEquals(1000, special.getSaleMoney());
    }

    @Test
    void 크리스마스_주문() {
        Special special = new Special(25);

        assertEquals(1000, special.getSaleMoney());
    }

    @Test
    void 평일_주문() {
        Special special = new Special(6);

        assertEquals(0, special.getSaleMoney());
    }
}
