package Ingredients;

public enum OtherIngredients {
    CHEESE("Сыр", 100, 50),
    CARROT_IN_KOREAN("Морковка по-корейски", 100, 50),
    SAUERKRAUT("Квашеная капуста", 100, 50),
    ONION_SWEET("Сладкий лук", 100, 50),
    JALAPENO("Перец халапенью", 100, 50),
    CHILLI("Перец чили", 100, 50),
    PICKLE("Соленый огурчик", 100, 50);

    private String nameIngredient;
    private double price;
    private int countInStore;

    OtherIngredients(String nameIngredient, double price, int countInStore) {
        this.nameIngredient = nameIngredient;
        this.price = price;
        this.countInStore = countInStore;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  nameIngredient + ": " + price + "$.";
    }

    public String showCountOtherIngredients() {
        return  nameIngredient + ": " + countInStore + "шт.";
    }

}
