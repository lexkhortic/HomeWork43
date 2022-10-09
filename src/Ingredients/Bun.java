package Ingredients;

public enum Bun {
    BUN_WHEAT("Булочка пшеничная", 100, 50),
    BUN_RYE("Булочка ржаная", 100, 50),
    BUN_CHEESE("Булочка сырная", 100, 50);

    private String nameBun;
    private double price;
    private int countInStore;

    Bun(String nameIngredient, double price, int countInStore) {
        this.nameBun = nameIngredient;
        this.price = price;
        this.countInStore = countInStore;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  nameBun + ": " + price + "$.";
    }

    public String showCountBun() {
        return  nameBun + ": " + countInStore + "шт.";
    }
}
