package ims;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class fileHandling {

    File productFile = new File("test.csv");
    File orderFile = new File("orders.csv");


    public ArrayList<Product> readProduct(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            Scanner sc = new Scanner(productFile);
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String input = sc.next();

                if (!Objects.equals(input, Character.toString('\n'))) {

                String[] inputArray = input.split(",");

                Product pr = new Product(Integer.parseInt(inputArray[0].replaceAll("\\s", "")), inputArray[1], inputArray[2], Integer.parseInt(inputArray[3].replaceAll("\\s", "")), inputArray[4], Double.parseDouble(inputArray[5].replaceAll("\\s", "")), Double.parseDouble(inputArray[6].replaceAll("\\s", "")));

                products.add(pr);
                }

            }
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }
    public ArrayList<Product> writeProducts(ArrayList<Product> prod) {

        try {
            FileWriter fw = new FileWriter(productFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i=0; i < prod.size(); i++)
            {
                bw.write(prod.get(i).getPId() + "," + prod.get(i).getPname() + "," + prod.get(i).getDescription() + "," + prod.get(i).getPQuantity() + "," + prod.get(i).getCategory() + "," + prod.get(i).getPrice() + "," + prod.get(i).getCost() + ";");
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

                if (!Objects.equals(input, Character.toString('\n'))) {

                    String[] inputArray = input.split(",");

                    Order order = new Order(Integer.parseInt(inputArray[0].replaceAll("\\s", "")), Integer.parseInt(inputArray[1].replaceAll("\\s", "")), Integer.parseInt(inputArray[2].replaceAll("\\s", "")), Double.parseDouble(inputArray[3].replaceAll("\\s", "")), Double.parseDouble(inputArray[4].replaceAll("\\s", "")));

                    orders.add(order);
                }

            }
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return orders;
    }
    public ArrayList<Order> writeOrders(ArrayList<Order> orders){

        try {
            FileWriter fw = new FileWriter(orderFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i=0; i < orders.size(); i++)
            {
                bw.write(orders.get(i).getOrder() + "," + orders.get(i).getPID() + "," + orders.get(i).getQuantity() + "," + orders.get(i).getAmount() + "," + orders.get(i).getCost() + ";");
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
