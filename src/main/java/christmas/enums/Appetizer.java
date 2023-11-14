package christmas.enums;

public enum Appetizer {
    MUSHROOM_SOUP("양송이수프", 6000, 1),
    TAPAS("타파스", 5500, 1),
    CAESAR_SALAD("시저샐러드", 8000, 1);

    private final String name;
    private final int price;
    private final int identifier;

    Appetizer(String name, int price, int identifier) {
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

    public int getIdentifier() {

        return identifier;
    }
}
