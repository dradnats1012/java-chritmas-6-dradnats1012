package christmas.model.event;

import christmas.enums.Badges;

public class Badge {

    private final int totalBenefitPrice;

    public Badge(int totalBenefitPrice) {

        this.totalBenefitPrice = totalBenefitPrice;
    }

    public String selectEventBadge() {

        if (totalBenefitPrice >= Badges.SANTA.getPrice()) {
            return Badges.SANTA.getName();
        }
        if (totalBenefitPrice >= Badges.TREE.getPrice()) {
            return Badges.TREE.getName();
        }
        if (totalBenefitPrice >= Badges.STAR.getPrice()) {
            return Badges.STAR.getName();
        }

        return Badges.NOTHING.getName();
    }
}
