package christmas.model.event;

import java.util.List;

public class WeekDay {
    private final List<Integer> menuTypeList;
    private int saleMoney = 0;

    public WeekDay(List<Integer> menuTypeList) {
        this.menuTypeList = menuTypeList;
        calculateSaleMoney(countDessert());
    }

    private void calculateSaleMoney(int count) {
        saleMoney += count * 2023;
    }

    private int countDessert() {
        int count = 0;
        for (Integer identifier : menuTypeList) {
            if (identifier == 3) {
                count++;
            }
        }

        return count;
    }

    public int getSaleMoney() {
        return saleMoney;
    }
}
