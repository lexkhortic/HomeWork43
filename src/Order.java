import HotDog.HotDog;

import java.util.ArrayList;

public class Order {
    private double totalPriceOrder = 0;
    private int idOrder;
    private ArrayList<HotDog> hotDogs;

    public Order(int idOrder) {
        this.idOrder = idOrder;
        hotDogs = new ArrayList<>();
    }

    public void setTotalPriceOrder(double totalPriceOrder) {
        this.totalPriceOrder = totalPriceOrder;
    }

    public double getTotalPriceOrder() {
        return totalPriceOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public ArrayList<HotDog> getHotDogs() {
        return hotDogs;
    }
}
