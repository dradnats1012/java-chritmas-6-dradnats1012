package christmas.model.event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveawayTest {
    @Test
    void 증정품_받음() {
        Giveaway giveaway = new Giveaway(120000);

        assertEquals(25000, giveaway.getBenefitMoney());
    }

    @Test
    void 증정품_못_받음() {
        Giveaway giveaway = new Giveaway(12000);

        assertEquals(0, giveaway.getBenefitMoney());
    }
}
