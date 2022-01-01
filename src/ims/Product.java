package ims;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private String category;
    private double price;
    private double cost;

    public Product()
    {
        id = 0;
        name = null;
        description = null;
        quantity = 0;
        category = null;
        price = 0.0;
        cost = 0.0;
    }

    public Product(int id, String name, String description, int quantity, String category, double price, double cost)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        this.cost = cost;
    }


    public int getPId()
    {
        return id;
    }

    public void setPname(String name)
    {
        this.name = name;
    }

    public String getPname()
    {
        return name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getPQuantity()
    {
        return quantity;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public double getCost()
    {
        return cost;
    }


    public void setCost(double cost)
    {
        this.cost = cost;
    }

}
