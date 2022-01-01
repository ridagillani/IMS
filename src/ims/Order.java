package ims;

public class Order {

    int product_id;
    int order_number;
    int quantity;
    double amount;

    public Order()
    {
        product_id = 0;
        order_number = 0;
        quantity = 0;
        amount = 0.0;
    }

    public Order(int order_number ,int product_id, int quantity, double amount)
    {
        this.product_id = product_id;
        this.order_number = order_number;
        this.quantity = quantity;
        this.amount = amount;

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

}
