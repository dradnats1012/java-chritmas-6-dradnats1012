package christmas.model.order;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderCalculatorTest {
    @Test
    void 가격_비교() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("타파스", 2),
                Map.of("제로콜라", 2)
        );

        TakeOrder takeOrder = new TakeOrder(menu);
        OrderCalculator orderCalculator = new OrderCalculator(takeOrder);

        assertEquals(17000, orderCalculator.calculateTotalMoney());
    }


}
