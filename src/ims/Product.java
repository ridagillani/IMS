package ims;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private String category;
    private double price;

    public Product(){
        id = 0;
        name = null;
        description = null;
        quantity = 0;
        category = null;
        price = 0.0;
    }
    public Product(int id, String name, String description, int quantity, String category, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }



}
