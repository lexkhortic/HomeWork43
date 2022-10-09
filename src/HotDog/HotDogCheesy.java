package HotDog;

import Ingredients.Bun;
import Ingredients.OtherIngredients;
import Ingredients.Sauce;
import Ingredients.Sausage;

//Сырный хот-дог
public class HotDogCheesy extends HotDog{
    private final OtherIngredients cheese = OtherIngredients.CHEESE;

    public HotDogCheesy() {
        super.setName("Сырный");
        super.setBun(Bun.BUN_CHEESE);
        super.setSausage(Sausage.SAUSAGE_CHEESE);
        super.setSauce(Sauce.CHEESY);
        super.setTotalPrice(Bun.BUN_CHEESE.getPrice() + Sausage.SAUSAGE_CHEESE.getPrice()
                + Sauce.CHEESY.getPrice() + cheese.getPrice());
    }

    @Override
    public String toString() {
        return "Хот-дог \"" + this.getName() + "\":\n" +
                Bun.BUN_CHEESE + "\n" +
                Sausage.SAUSAGE_CHEESE + "\n" +
                Sauce.CHEESY + "\n" +
                cheese + "\n" +
                "----------------------" + this.getTotalPrice() + "$.\n";
    }

    public static double getPriceForMenu() {
        return Bun.BUN_CHEESE.getPrice() + Sausage.SAUSAGE_CHEESE.getPrice()
                + Sauce.CHEESY.getPrice() + OtherIngredients.CHEESE.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotDogCheesy that = (HotDogCheesy) o;

        return cheese == that.cheese;
    }

    @Override
    public int hashCode() {
        return cheese != null ? cheese.hashCode() : 0;
    }
}
