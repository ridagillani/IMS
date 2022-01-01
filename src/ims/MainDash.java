package ims;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainDash extends JPanel {
    fileHandling fileM = new fileHandling();

    ArrayList<Product> products = fileM.readProduct();
    ArrayList<Order> orders = fileM.readOrders();

    int available = 0;
    int sold = 0;
    double revenue = 0.0;
    double profitA = 0.0;


    public MainDash ()
    {
        calculate();
        setBackground(Color.white);
        setLayout(new BorderLayout());

        Container dashBox = new Container();
        dashBox.setLayout(new GridLayout(2,2,10,10));

        JLabel stockLabel = new JLabel();
        stockLabel.setText("Available Stock: ");
        stockLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel stockAmount = new JLabel();
        stockAmount.setText(Integer.toString(available));
        stockAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel stock = new JPanel();
        stock.setLayout(new GridBagLayout());

        stock.add(stockLabel);
        stock.add(stockAmount);

        JLabel soldLabel = new JLabel();
        soldLabel.setText("Sold Items: ");
        soldLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel soldAmount = new JLabel();
        soldAmount.setText(Integer.toString(sold));
        soldAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel sold = new JPanel();
        sold.setLayout(new GridBagLayout());

        sold.add(soldLabel);
        sold.add(soldAmount);

        JLabel totalProfitLabel = new JLabel();
        totalProfitLabel.setText("Revenue: ");
        totalProfitLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel profitAmount = new JLabel();
        profitAmount.setText(Double.toString(revenue));
        profitAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel profit = new JPanel();
        profit.setLayout(new GridBagLayout());

        profit.add(totalProfitLabel);
        profit.add(profitAmount);

        JLabel lossLabel = new JLabel();
        lossLabel.setText("Profit: ");
        lossLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel  lossAmount = new JLabel();
        lossAmount.setText(Double.toString(profitA));
        lossAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel loss = new JPanel();
        loss.setLayout(new GridBagLayout());

        loss.add(lossLabel);
        loss.add(lossAmount);


        dashBox.add(stock);
        dashBox.add(sold);
        dashBox.add(profit);
        dashBox.add(loss);

        add(dashBox , BorderLayout.CENTER);

    }

    void calculate () {
        for (int i = 0; i < products.size(); i++) {
            available = available + products.get(i).getPQuantity();
        }
        double cost = 0;

        for (int j = 0; j < orders.size(); j++) {
            sold = sold + orders.get(j).getQuantity();
            revenue = revenue + orders.get(j).getAmount();
            cost = cost + orders.get(j).getCost();

            profitA = revenue - cost;
        }

        System.out.println(cost);
    }

}
