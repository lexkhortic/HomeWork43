package HotDog;

import Ingredients.Bun;
import Ingredients.OtherIngredients;
import Ingredients.Sauce;
import Ingredients.Sausage;

import java.util.Objects;

//Хот-дог "Ассорти"
public class HotDogAssorted extends HotDog{
    private final OtherIngredients sauerkraut = OtherIngredients.SAUERKRAUT;
    private final OtherIngredients carrotInKorean = OtherIngredients.CARROT_IN_KOREAN;
    private final Sauce mayonnaise = Sauce.MAYONNAISE;

    public HotDogAssorted() {
        super.setName("Ассорти");
        super.setBun(Bun.BUN_WHEAT);
        super.setSausage(Sausage.SAUSAGE_BEEF);
        super.setSauce(Sauce.KETCHUP);
        super.setTotalPrice(Bun.BUN_WHEAT.getPrice() + Sausage.SAUSAGE_BEEF.getPrice()
                + Sauce.KETCHUP.getPrice() + sauerkraut.getPrice() + carrotInKorean.getPrice() + mayonnaise.getPrice());
    }

    @Override
    public String toString() {
        return "Хот-дог \"" + this.getName() + "\":\n" +
                Bun.BUN_WHEAT + "\n" +
                Sausage.SAUSAGE_BEEF + "\n" +
                Sauce.KETCHUP + "\n" +
                mayonnaise + "\n" +
                sauerkraut + "\n" +
                carrotInKorean + "\n" +
                "----------------------" + this.getTotalPrice() + "$.\n";
    }

    public static double getPriceForMenu() {
        return Bun.BUN_WHEAT.getPrice() + Sausage.SAUSAGE_BEEF.getPrice()
                + Sauce.KETCHUP.getPrice() +  OtherIngredients.SAUERKRAUT.getPrice()
                + OtherIngredients.CARROT_IN_KOREAN.getPrice() + Sauce.MAYONNAISE.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotDogAssorted that = (HotDogAssorted) o;

        if (sauerkraut != that.sauerkraut) return false;
        if (carrotInKorean != that.carrotInKorean) return false;
        return mayonnaise == that.mayonnaise;
    }

    @Override
    public int hashCode() {
        int result = sauerkraut != null ? sauerkraut.hashCode() : 0;
        result = 31 * result + (carrotInKorean != null ? carrotInKorean.hashCode() : 0);
        result = 31 * result + (mayonnaise != null ? mayonnaise.hashCode() : 0);
        return result;
    }
}
