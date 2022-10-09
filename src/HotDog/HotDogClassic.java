package HotDog;

import Ingredients.Bun;
import Ingredients.Sauce;
import Ingredients.Sausage;

//Классический хот-дог
public class HotDogClassic extends HotDog{

    public HotDogClassic() {
        super.setName("Классический");
        super.setBun(Bun.BUN_WHEAT);
        super.setSausage(Sausage.SAUSAGE_PORK);
        super.setSauce(Sauce.KETCHUP);
        super.setTotalPrice(Bun.BUN_WHEAT.getPrice() + Sausage.SAUSAGE_PORK.getPrice() + Sauce.KETCHUP.getPrice());
    }

    @Override
    public String toString() {
        return "Хот-дог \"" + this.getName() + "\":\n" +
                Bun.BUN_WHEAT + "\n" +
                Sausage.SAUSAGE_PORK + "\n" +
                Sauce.KETCHUP + "\n" +
                "----------------------" + this.getTotalPrice() + "$.\n";
    }

    public static double getPriceForMenu() {
        return Bun.BUN_WHEAT.getPrice() + Sausage.SAUSAGE_PORK.getPrice() + Sauce.KETCHUP.getPrice();
    }




}
