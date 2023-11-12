package christmas.message;

import java.io.Console;

public enum ConsoleMessage {
    WELCME_EVENT_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    EXPECTED_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENU_NAME_QUANTITY("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_BENEFITS_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_PRICE("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    CHAMPAGNE("샴페인 %d개"),
    BENEFIT_DETAILS("<혜택 내역>"),
    CHRISTMAS_D_DAY_SALE("크리스마스 디데이 할인: -%s원"),
    WEEKDAY_SALE("평일 할인: -%s원"),
    WEEKEND_SALE("주말 할인: -%s원"),
    SPECIAL_SALE("특별 할인: -%s원"),
    TOTAL_BENEFITS_PRICE("<총혜택 금액>"),
    PRICE_AFTER_SALE("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("12월 이벤트 배지");
    private final String message;

    ConsoleMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
