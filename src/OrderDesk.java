import HotDog.HotDog;
import HotDog.HotDogAssorted;
import HotDog.HotDogCheesy;
import HotDog.HotDogClassic;
import HotDog.UserHotDog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class OrderDesk {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private double totalCashOrderDesk;
    private int idOrder = 1;
    private HashMap<HotDog, Integer> soldHotDogs = new HashMap<>();

    public void start() {
        Order order = new Order(idOrder);
        showMenu(order);
    }

    private void showMenu(Order order) {
        if (order.getHotDogs().size() == 0) {
            showTitle();
        } else {
            showTitleWithPay();
        }

        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1: {
                    HotDogClassic hotDogClassic = CreateHotDogs.createClassicHotDog(order);
                    addSoldHotDog(hotDogClassic);
                    showMenu(order);
                    break;
                }
                case 2: {
                    HotDogCheesy hotDogCheesy = CreateHotDogs.createCheesyHotDog(order);
                    addSoldHotDog(hotDogCheesy);
                    showMenu(order);
                    break;
                }
                case 3: {
                    HotDogAssorted hotDogAssorted = CreateHotDogs.createAssortedHotDog(order);
                    addSoldHotDog(hotDogAssorted);
                    showMenu(order);
                    break;
                }
                case 4: {
                    UserHotDog userHotDog = CreateHotDogs.createUserHotDog(order);
                    addSoldHotDog(userHotDog);
                    showMenu(order);
                    break;
                }
                case 5: {
                    if (order.getHotDogs().size() == 0) {
                        System.out.println("Ваша карзина еще пуста, добавьте товар!");
                        showMenu(order);
                    } else {
                        Payment payment = new Payment();
                        while (true) {
                            if (payment.startPay(this, order)) {
                                System.out.println("Приятного аппетита! Приходите ещё :)\n");
                                break;
                            } else {
                                System.out.println("Оплата не прошла :( Попробуйте снова!");
                            }
                        }
                        idOrder++;
                        start();
                        break;
                    }
                }
                case 6: {
                    soldHotDogs.clear();
                    totalCashOrderDesk = 0;
                    start();
                    break;
                }

                case 0: {
                    if (showAdminFunc() == 1) {
                        Administrator.checkedPassword(this);
                        showMenu(order);
                    } else {
                        showMenu(order);
                    }
                }

                default:
                    System.out.println("Такого выбора нет :)");
                    showMenu(order);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addSoldHotDog(HotDog hotDog) {
        if (!soldHotDogs.containsKey(hotDog)) {
            soldHotDogs.put(hotDog, 1);
        } else {
            soldHotDogs.entrySet().forEach(k -> {
                if (k.getKey().getName().equals(hotDog.getName())) {
                    k.setValue(k.getValue() + 1);
                }
            });
        }
    }

    private static void showTitle() {
        System.out.println("-------------------------------------------");
        System.out.println("           HOT DOG WITHOUT DOG             ");
        System.out.println("-------------------------------------------");
        System.out.println(
                "Здравствуйте, мы всегда рады Вас накормить!\n" +
                        "1 - Хот-дог \"Классический\"------" + HotDogClassic.getPriceForMenu() + "$;\n" +
                        "2 - Хот-дог \"Сырный\"------------" + HotDogCheesy.getPriceForMenu() + "$;\n" +
                        "3 - Хот-дог \"Ассорти\"-----------" + HotDogAssorted.getPriceForMenu() + "$;\n" +
                        "4 - Хот-дог по индивидуальному рецепту;\n" +
                        "0 - АДМИНИСТРАТОР");
        System.out.print("Выбирете позицию для заказа: ");
    }

    private static void showTitleWithPay() {
        System.out.println(
                        "1 - Хот-дог \"Классический\"------" + HotDogClassic.getPriceForMenu() + "$;\n" +
                        "2 - Хот-дог \"Сырный\"------------" + HotDogCheesy.getPriceForMenu() + "$;\n" +
                        "3 - Хот-дог \"Ассорти\"-----------" + HotDogAssorted.getPriceForMenu() + "$;\n" +
                        "4 - Хот-дог по индивидуальному рецепту;\n" +
                        "5 - ОПЛАТИТЬ;\n" +
                        "6 - ВЫХОД");
        System.out.print("Выбирете позицию: ");
    }

    private static int showAdminFunc() {
        System.out.println("\nАДМИНИСТРАТОР:\n" +
                        "1 - Ввести пароль;\n" +
                        "2 - НАЗАД;");
        System.out.print("Выбирете позицию: ");
        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (choice == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    public double getTotalCashOrderDesk() {
        return totalCashOrderDesk;
    }

    public void setTotalCashOrderDesk(double totalCashOrderDesk) {
        this.totalCashOrderDesk = totalCashOrderDesk;
    }

    public HashMap<HotDog, Integer> getSoldHotDogs() {
        return soldHotDogs;
    }

}
