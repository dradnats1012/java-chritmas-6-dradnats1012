package christmas.model.order;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
