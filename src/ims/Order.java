package ims;

public class Order {

    int product_id;
    int order_number;
    int quantity;
    double amount;
    double cost;

    public Order()
    {
        product_id = 0;
        order_number = 0;
        quantity = 0;
        amount = 0.0;
        cost = 0.0;
    }

    public Order(int order_number ,int product_id, int quantity, double amount, double cost)
    {
        this.product_id = product_id;
        this.order_number = order_number;
        this.quantity = quantity;
        this.amount = amount;
        this.cost = cost;

    }



    public int getPID()
    {
        return this.product_id;
    }


    public int getOrder()
    {
        return order_number;
    }


    public int getQuantity()
    {
        return quantity;
    }

    public double getAmount()
    {
        return amount;
    }

    public double getCost() { return cost; }

}
