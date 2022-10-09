package Ingredients;

public enum Sausage {
    SAUSAGE_CHICKEN("Сосиска куриная", 100, 50),
    SAUSAGE_BEEF("Сосиска говяжья", 100, 50),
    SAUSAGE_PORK("Сосиска свиная", 100, 50),
    SAUSAGE_CHEESE("Сосиска с сыром", 100, 50);

    private String nameSausage;
    private double price;
    private int countInStore;

    Sausage(String nameSausage, double price, int countInStore) {
        this.nameSausage = nameSausage;
        this.price = price;
        this.countInStore = countInStore;
    }

    public String getNameSausage() {
        return nameSausage;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  nameSausage + ": " + price + "$.";
    }

    public String showCountSausage() {
        return  nameSausage + ": " + countInStore + "шт.";
    }
}
