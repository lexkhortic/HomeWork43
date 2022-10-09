import HotDog.HotDogAssorted;
import HotDog.HotDogCheesy;
import HotDog.HotDogClassic;
import HotDog.UserHotDog;

public class CreateHotDogs {

    public static HotDogClassic createClassicHotDog(Order order) {
        HotDogClassic hotDogClassic = new HotDogClassic();
        order.getHotDogs().add(hotDogClassic);
        order.setTotalPriceOrder(order.getTotalPriceOrder() + hotDogClassic.getTotalPrice());
        System.out.println("Хот-дог " + "\"" + hotDogClassic.getName() + "\" добавлен в козину!\n");
        return hotDogClassic;
    }

    public static HotDogCheesy createCheesyHotDog(Order order) {
        HotDogCheesy hotDogCheesy = new HotDogCheesy();
        order.getHotDogs().add(hotDogCheesy);
        order.setTotalPriceOrder(order.getTotalPriceOrder() + hotDogCheesy.getTotalPrice());
        System.out.println("Хот-дог " + "\"" + hotDogCheesy.getName() + "\" добавлен в козину!\n");
        return hotDogCheesy;
    }

    public static HotDogAssorted createAssortedHotDog(Order order) {
        HotDogAssorted hotDogAssorted = new HotDogAssorted();
        order.getHotDogs().add(hotDogAssorted);
        order.setTotalPriceOrder(order.getTotalPriceOrder() + hotDogAssorted.getTotalPrice());
        System.out.println("Хот-дог " + "\"" + hotDogAssorted.getName() + "\" добавлен в козину!\n");
        return hotDogAssorted;
    }

    public static UserHotDog createUserHotDog(Order order) {
        UserHotDog userHotDog = new UserHotDog();
        order.getHotDogs().add(userHotDog);
        order.setTotalPriceOrder(order.getTotalPriceOrder() + userHotDog.getTotalPrice());
        System.out.println("Хот-дог " + "\"" + userHotDog.getName() + "\" добавлен в козину!\n");
        return userHotDog;
    }

}
