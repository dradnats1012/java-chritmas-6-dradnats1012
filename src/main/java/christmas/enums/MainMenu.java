package christmas.enums;

public enum MainMenu {

    T_BONE_STAKE("티본스테이크", 55000, 2),
    BARBECUE_RIB("바비큐립", 54000, 2),
    SEAFOOD_PASTA("해산물파스타", 35000, 2);
    private final String name;
    private final int price;
    private final int identifier;

    MainMenu(String name, int price, int identifier) {

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
