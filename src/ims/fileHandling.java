package ims;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class fileHandling {


    public ArrayList<Product> readProduct(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            File file = new File("test.csv");
            Scanner sc = new Scanner(file);
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String input = sc.next();

                if (!Objects.equals(input, Character.toString('\n'))) {

                String[] inputArray = input.split(",");

                Product pr = new Product(Integer.parseInt(inputArray[0].replaceAll("\\s", "")), inputArray[1], inputArray[2], Integer.parseInt(inputArray[3].replaceAll("\\s", "")), inputArray[4], Double.parseDouble(inputArray[5].replaceAll("\\s", "")));

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
            File file = new File("test.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i=0; i < prod.size(); i++)
            {
                bw.write(prod.get(i).getPId() + "," + prod.get(i).getPname() + "," + prod.get(i).getDescription() + "," + prod.get(i).getPQuantity() + "," + prod.get(i).getCategory() + "," + prod.get(i).getPrice() + ";");
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("Exception Found");
        }

        return prod;
    }

    public ArrayList<Product> readOrders(){
        ArrayList<Product> products = new ArrayList<>();
        return products;
    }
    public ArrayList<Product> writeOrders(){
        ArrayList<Product> products = new ArrayList<>();
        return products;
    }

}
