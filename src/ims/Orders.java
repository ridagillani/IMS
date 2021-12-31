package ims;

public class Orders {

    int product_id;
    int order_number;
    int quantity;
    double amount;

    public Orders()
    {
        product_id = 0;
        order_number = 0;
        quantity = 0;
        amount = 0.0;
    }

    public Orders(int product_id, int order_number, int quantity, double amount)
    {
        this.product_id = product_id;
        this.order_number = order_number;
        this.quantity = quantity;
        this.amount = amount;

    }

    public void setID(int product_id)
    {
        this.product_id = product_id;
    }

    public int getID()
    {
        return product_id;
    }

    public void setOrder(int order)
    {
        this.order_number = order_number;
    }

    public int getOrder()
    {
        return order_number;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }

}
