package christmas.model.order;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TakeOrderTest {

    @Test
    void 음료만_주문시_예외() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("제로콜라", 2)
        );

        assertThatThrownBy(() -> new TakeOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_0_이면_예외() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("타파스", 0)
        );

        assertThatThrownBy(() -> new TakeOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_20_초과면_예외() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("타파스", 21)
        );

        assertThatThrownBy(() -> new TakeOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴판에_없으면_예외() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("쿨피스", 2)
        );

        assertThatThrownBy(() -> new TakeOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴가_중복이면_예외() {
        List<Map<String, Integer>> menu = List.of(
                Map.of("타파스", 2),
                Map.of("타파스", 2)
        );

        assertThatThrownBy(() -> new TakeOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
