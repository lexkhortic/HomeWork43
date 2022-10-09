package Ingredients;

public enum Sauce {
    KETCHUP("Кетчуп", 100, 50),
    CHEESY("Сырный соус", 100, 50),
    MAYONNAISE("Майонез", 100, 50),
    MUSTARD("Горчица", 100, 50),
    TERIYAKI("Терияки", 100, 50);

    private String nameSauce;
    private double price;
    private int countInStore;

    Sauce(String nameSauce, double price, int countInStore) {
        this.nameSauce = nameSauce;
        this.price = price;
        this.countInStore = countInStore;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  nameSauce + ": " + price + "$.";
    }

    public String showCountSauce() {
        return  nameSauce + ": " + countInStore + "шт.";
    }
}
