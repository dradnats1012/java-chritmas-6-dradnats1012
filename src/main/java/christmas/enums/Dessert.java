package christmas.enums;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000, 3),
    ICE_CREAM("아이스크림", 5000, 3);

    private final String name;
    private final int price;
    private final int identifier;
    private static final int DESSERT_MENU = 3;

    Dessert(String name, int price, int identifier) {
        this.name = name;
        this.price = price;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getIdentifier(){
        return identifier;
    }
}
