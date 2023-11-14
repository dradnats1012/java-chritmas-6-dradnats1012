package christmas.model.order;

import java.util.List;

public class OrderCalculator {

    private final List<Integer> menuPriceList;
    private final List<Integer> menuCountList;
    private final int length;
    private int total = 0;

    public OrderCalculator(TakeOrder takeOrder){
        this.menuPriceList = takeOrder.getMenuPriceList();
        this.menuCountList = takeOrder.getMenuCountList();
        this.length = menuCountList.size();
    }

    public int calculateTotalMoney(){

        for(int i = 0; i < length; i++){
            total += menuPriceList.get(i) * menuCountList.get(i);
        }

        return total;
    }
}
