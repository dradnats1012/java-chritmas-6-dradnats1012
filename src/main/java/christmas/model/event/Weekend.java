package christmas.model.event;

import java.util.List;

public class Weekend {
    private final List<Integer> menuTypeList;
    private int saleMoney = 0;

    public Weekend(List<Integer> menuTypeList) {
        this.menuTypeList = menuTypeList;
        calculateSaleMoney(countMain());
    }

    private void calculateSaleMoney(int count) {
        saleMoney += count * 2023;
    }

    private int countMain() {
        int count = 0;

        for (Integer identifier : menuTypeList) {
            if (identifier == 2) {
                count++;
            }
        }

        return count;
    }

    public int getSaleMoney() {
        return saleMoney;
    }
}
