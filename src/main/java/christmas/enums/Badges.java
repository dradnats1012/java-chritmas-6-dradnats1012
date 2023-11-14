package christmas.enums;

public enum Badges {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOTHING("없음", 0);

    private final String name;
    private final int lowerLimitPrice;

    Badges(String name, int lowerLimitPrice) {

        this.name = name;
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return lowerLimitPrice;
    }
}
