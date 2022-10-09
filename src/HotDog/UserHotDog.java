package HotDog;

import Ingredients.Bun;
import Ingredients.OtherIngredients;
import Ingredients.Sauce;
import Ingredients.Sausage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UserHotDog extends HotDog {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ArrayList<OtherIngredients> otherIngredients;
    private double sumPriceOtherIngredients = 0;

    public UserHotDog() {
        super.setName("Пользовательский");
        super.setBun(choiceBun());
        super.setSausage(choiceSausage());
        super.setSauce(choiceSauce());
        otherIngredients = choiceOtherIngredients();
        super.setTotalPrice(super.getBun().getPrice() + super.getSausage().getPrice() + super.getSauce().getPrice()
                + sumPriceOtherIngredients);
    }

    public ArrayList<OtherIngredients> getOtherIngredients() {
        return otherIngredients;
    }

    private Bun choiceBun() {
        System.out.println("Выберете булочку: ");
        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(Bun.values()).forEach(el -> {
            System.out.println(i.getAndIncrement() + " - " + el);
        });
        System.out.print("Ваш выбор: ");

        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (choice) {
            case 1: {
                return Bun.BUN_WHEAT;
            }
            case 2: {
                return Bun.BUN_RYE;
            }
            case 3: {
                return Bun.BUN_CHEESE;
            }
            default:
                return Bun.BUN_WHEAT;
        }
    }

    private Sausage choiceSausage() {
        System.out.println("Выберете сосиску: ");
        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(Sausage.values()).forEach(el -> {
            System.out.println(i.getAndIncrement() + " - " + el);
        });
        System.out.print("Ваш выбор: ");

        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (choice) {
            case 1: {
                return Sausage.SAUSAGE_CHICKEN;
            }
            case 2: {
                return Sausage.SAUSAGE_BEEF;
            }
            case 3: {
                return Sausage.SAUSAGE_PORK;
            }
            case 4: {
                return Sausage.SAUSAGE_CHEESE;
            }
            default:
                return Sausage.SAUSAGE_PORK;
        }
    }

    private Sauce choiceSauce() {
        System.out.println("Выберете соус: ");
        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(Sauce.values()).forEach(el -> {
            System.out.println(i.getAndIncrement() + " - " + el);
        });
        System.out.print("Ваш выбор: ");

        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (choice) {
            case 1: {
                return Sauce.KETCHUP;
            }
            case 2: {
                return Sauce.CHEESY;
            }
            case 3: {
                return Sauce.MAYONNAISE;
            }
            case 4: {
                return Sauce.MUSTARD;
            }
            case 5: {
                return Sauce.TERIYAKI;
            }
            default:
                return Sauce.KETCHUP;
        }
    }

    private ArrayList<OtherIngredients> choiceOtherIngredients() {
        ArrayList<OtherIngredients> ingredients = new ArrayList<>();
        OtherIngredients[] arrayIngredientsEnum = OtherIngredients.values();
        boolean enough = false;
        while (!enough) {
            System.out.println("Выберете доп. ингредиенты: ");
            AtomicInteger i = new AtomicInteger(1);
            Arrays.stream(arrayIngredientsEnum).forEach(el -> {
                System.out.println(i.getAndIncrement() + " - " + el);
            });
            System.out.println("0 - ВЫХОД;");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1: {
                    ingredients.add(OtherIngredients.CHEESE);
                    sumPriceOtherIngredients += OtherIngredients.CHEESE.getPrice();
                    break;
                }
                case 2: {
                    ingredients.add(OtherIngredients.CARROT_IN_KOREAN);
                    sumPriceOtherIngredients += OtherIngredients.CARROT_IN_KOREAN.getPrice();
                    break;
                }
                case 3: {
                    ingredients.add(OtherIngredients.SAUERKRAUT);
                    sumPriceOtherIngredients += OtherIngredients.SAUERKRAUT.getPrice();
                    break;
                }
                case 4: {
                    ingredients.add(OtherIngredients.ONION_SWEET);
                    sumPriceOtherIngredients += OtherIngredients.ONION_SWEET.getPrice();
                    break;
                }
                case 5: {
                    ingredients.add(OtherIngredients.JALAPENO);
                    sumPriceOtherIngredients += OtherIngredients.JALAPENO.getPrice();
                    break;
                }
                case 6: {
                    ingredients.add(OtherIngredients.CHILLI);
                    sumPriceOtherIngredients += OtherIngredients.CHILLI.getPrice();
                    break;
                }
                case 7: {
                    ingredients.add(OtherIngredients.PICKLE);
                    sumPriceOtherIngredients += OtherIngredients.PICKLE.getPrice();
                    break;
                }
                case 0: {
                    enough = true;
                    break;
                }
                default:
                    System.out.println("Такого ингредиента нет :(");
            }
        }
        return ingredients;
    }

    @Override
    public String toString() {
        StringBuilder otherIngredientsString = new StringBuilder();
        this.otherIngredients.forEach(el -> {
            otherIngredientsString.append(el).append("\n");
        });
        return "Хот-дог \"" + this.getName() + "\":\n" +
                this.getBun() + "\n" +
                this.getSausage() + "\n" +
                this.getSauce() + "\n" +
                 otherIngredientsString +
                "----------------------" + this.getTotalPrice() + "$.\n";
    }
}
