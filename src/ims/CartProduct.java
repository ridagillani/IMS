package ims;

public class CartProduct {
    private int id;
    private String name;
    private int quantity;
    private double totalPrice;
    private double totalCost;

    public CartProduct()
    {
        id = 0;
        name = null;
        quantity = 0;
        totalPrice = 0.0;
        totalCost = 0.0;
    }

    public CartProduct(int id, String name, int quantity, double price, double cost)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = price;
        this.totalCost = cost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void addOne(double price, double cost) {
        this.quantity = this.quantity + 1;
        this.totalPrice = this.totalPrice + price;
        this.totalCost = this.totalCost + cost;
    }
}
