package ims;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileHandling {

    File productFile = new File("products.csv");
    File orderFile = new File("orders.csv");


    public ArrayList<Product> readProduct(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            Scanner sc = new Scanner(productFile);
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String input = sc.next();

                if (!Objects.equals(input, Character.toString('\n')) && !Objects.equals(input, "")) {

                    String[] inputArray = input.split(",");

                    Product pr = new Product(Integer.parseInt(inputArray[0].replaceAll("\\s", "")), inputArray[1], inputArray[2], Integer.parseInt(inputArray[3].replaceAll("\\s", "")), inputArray[4], Double.parseDouble(inputArray[5].replaceAll("\\s", "")), Double.parseDouble(inputArray[6].replaceAll("\\s", "")));

                    products.add(pr);
                }

            }
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    public ArrayList<Product> writeProducts(ArrayList<Product> prod) {

        try {
            FileWriter fw = new FileWriter(productFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Product product : prod) {
                bw.write(product.getPId() + "," + product.getPname() + "," + product.getDescription() + "," + product.getPQuantity() + "," + product.getCategory() + "," + product.getPrice() + "," + product.getCost() + ";");
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("Exception Found");
        }

        return prod;
    }

    public ArrayList<Order> readOrders(){
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Scanner sc = new Scanner(orderFile);
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String input = sc.next();

                if (!Objects.equals(input, Character.toString('\n')) && !Objects.equals(input, "")) {

                    String[] inputArray = input.split(",");

                    Order order = new Order(Integer.parseInt(inputArray[0].replaceAll("\\s", "")), Integer.parseInt(inputArray[1].replaceAll("\\s", "")), Integer.parseInt(inputArray[2].replaceAll("\\s", "")), Double.parseDouble(inputArray[3].replaceAll("\\s", "")), Double.parseDouble(inputArray[4].replaceAll("\\s", "")));

                    orders.add(order);
                }

            }
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }
    public ArrayList<Order> writeOrders(ArrayList<Order> orders){

        try {
            FileWriter fw = new FileWriter(orderFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Order order : orders) {
                bw.write(order.getOrder() + "," + order.getPID() + "," + order.getQuantity() + "," + order.getAmount() + "," + order.getCost() + ";");
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("Exception Found");
        }

        return orders;
    }

}
