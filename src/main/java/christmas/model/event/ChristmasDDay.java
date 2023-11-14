package christmas.model.event;

public class ChristmasDDay {

    private final int date;
    private int saleMoney = 1000;

    public ChristmasDDay(int date) {
        this.date = date;
        calculateDDaySale();
    }

    private boolean isValidateDate() {
        return date >= 26;
    }

    private void calculateDDaySale() {

        if (isValidateDate()) {
            saleMoney = 0;
            return;
        }

        saleMoney += (date - 1) * 100;
    }

    public int getSaleMoney() {

        return saleMoney;
    }
}
