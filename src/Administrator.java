import Ingredients.Bun;
import Ingredients.OtherIngredients;
import Ingredients.Sauce;
import Ingredients.Sausage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Administrator {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int password = 12345;

    public static void checkedPassword(OrderDesk orderDesk) {
        try {
            System.out.print("Введите пароль от кассы:");
            if (password == Integer.parseInt(reader.readLine())) {
                while (true) {
                    showMenuAdmin();
                    int choice = Integer.parseInt(reader.readLine());
                    switch (choice) {
                        case 1:
                            showRevenue(orderDesk);
                            break;
                        case 2:
                            showSoldHotDogs(orderDesk);
                            break;
                        case 3:
                            showIngredientsInStore();
                            break;
                        default:
                            return;

                    }
                }
            } else {
                System.out.println("Пароль не верен!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showMenuAdmin() {
        System.out.println("Функции кассы:\n" +
                "1 - Показать выручку;\n" +
                "2 - Показать кол-во проданых хот-догов;\n" +
                "3 - Показать кол-во продуктов в магазине;\n" +
                "0 - ВЫХОД;");
        System.out.print("Выбирете позицию: ");
    }

    private static void showRevenue(OrderDesk orderDesk) {
        System.out.println("Выручка кассы составлет: " + orderDesk.getTotalCashOrderDesk() + "$.\n");
    }

    private static void showSoldHotDogs(OrderDesk orderDesk) {
        System.out.println("Проданые хот-доги:");
        orderDesk.getSoldHotDogs().forEach((key, value) ->
                System.out.println("Хот-дог: \"" + key.getName() + "\" - " + value + " шт."));
        System.out.println();
    }

    private static void showIngredientsInStore() {
        System.out.println("----------------------------");
        System.out.println("Булочки для хот-дога:");
        Arrays.stream(Bun.values()).forEach(el -> {
            System.out.println(el.showCountBun());
        });
        System.out.println();

        System.out.println("Сосиски для хот-дога:");
        Arrays.stream(Sausage.values()).forEach(el -> {
            System.out.println(el.showCountSausage());
        });
        System.out.println();

        System.out.println("Соусы для хот-дога:");
        Arrays.stream(Sauce.values()).forEach(el -> {
            System.out.println(el.showCountSauce());
        });
        System.out.println();

        System.out.println("Другие ингредиенты для хот-дога:");
        Arrays.stream(OtherIngredients.values()).forEach(el -> {
            System.out.println(el.showCountOtherIngredients());
        });
        System.out.println("----------------------------");

    }
}
