package HotDog;

import Ingredients.Bun;
import Ingredients.Sauce;
import Ingredients.Sausage;

import java.util.Objects;

public class HotDog {
    private String name;
    private Bun bun;
    private Sausage sausage;
    private Sauce sauce;
    private double TotalPrice;

    public HotDog() {
    }

    public HotDog(Bun bun, Sausage sausage, Sauce sauce, double totalPrice) {
        this.bun = bun;
        this.sausage = sausage;
        this.sauce = sauce;
        TotalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bun getBun() {
        return bun;
    }

    public void setBun(Bun bun) {
        this.bun = bun;
    }

    public Sausage getSausage() {
        return sausage;
    }

    public void setSausage(Sausage sausage) {
        this.sausage = sausage;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotDog hotDog = (HotDog) o;

        if (Double.compare(hotDog.TotalPrice, TotalPrice) != 0) return false;
        if (!Objects.equals(name, hotDog.name)) return false;
        if (bun != hotDog.bun) return false;
        if (sausage != hotDog.sausage) return false;
        return sauce == hotDog.sauce;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (bun != null ? bun.hashCode() : 0);
        result = 31 * result + (sausage != null ? sausage.hashCode() : 0);
        result = 31 * result + (sauce != null ? sauce.hashCode() : 0);
        temp = Double.doubleToLongBits(TotalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
