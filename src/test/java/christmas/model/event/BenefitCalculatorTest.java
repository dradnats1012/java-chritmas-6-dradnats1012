package christmas.model.event;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BenefitCalculatorTest {
    @Test
    void 특별한날_평일_증정품_디저트3개() {
        List<Integer> menuTypeList = Arrays.asList(1, 1, 2, 3, 3, 3);
        BenefitCalculator benefitCalculator = new BenefitCalculator(3, 120000, menuTypeList);

        assertEquals(33269, benefitCalculator.getBenefitMoney());
    }

    @Test
    void 주말_메인1개() {
        List<Integer> menuTypeList = Arrays.asList(1, 1, 2, 3, 3, 3);
        BenefitCalculator benefitCalculator = new BenefitCalculator(2, 10000, menuTypeList);

        assertEquals(3123, benefitCalculator.getBenefitMoney());
    }

    @Test
    void 가격_10000원_미만() {
        List<Integer> menuTypeList = Arrays.asList(1, 1, 2, 3, 3, 3);
        BenefitCalculator benefitCalculator = new BenefitCalculator(2, 9000, menuTypeList);

        assertEquals(0, benefitCalculator.getBenefitMoney());
    }
}
