package christmas.enums;

public enum Beverage {
    ZERO_COKE("제로콜라", 3000,4),
    RED_WINE("레드와인", 60000,4),
    CHAMPAGNE("샴페인", 25000,4)
    ;
    private final String name;
    private final int price;
    private final int identifier;
    private static final int BEVERAGE_MENU = 4;

    Beverage(String name, int price, int identifier){
        this.name = name;
        this.price = price;
        this.identifier = identifier;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getIdentifier(){return identifier;}
}
