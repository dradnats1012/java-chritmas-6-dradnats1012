package christmas.model.event;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BadgeTest {

    @Test
    void 별_배지_확인() {
        Badge badge = new Badge(5000);
        assertEquals("별", badge.selectEventBadge());
    }

    @Test
    void 트리_배지_확인() {
        Badge badge = new Badge(10000);
        assertEquals("트리", badge.selectEventBadge());
    }

    @Test
    void 산타_배지_확인() {
        Badge badge = new Badge(20000);
        assertEquals("산타", badge.selectEventBadge());
    }

    @Test
    void 배지_없음_확인() {
        Badge badge = new Badge(3000);
        assertEquals("없음", badge.selectEventBadge());
    }
}
