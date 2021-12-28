package ims;

import javax.swing.*;
import java.awt.*;

public class MainDash extends JPanel {
    public MainDash ()
    {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        Container dashBox = new Container();
        dashBox.setLayout(new GridLayout(2,2,10,10));

        JLabel stockLabel = new JLabel();
        stockLabel.setText("Total Stock: ");
        stockLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel stockAmount = new JLabel();
        stockAmount.setText("125");
        stockAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel stock = new JPanel();
        stock.setLayout(new GridBagLayout());

        stock.add(stockLabel);
        stock.add(stockAmount);



        JLabel soldLabel = new JLabel();
        soldLabel.setText("Sold Items: ");
        soldLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel soldAmount = new JLabel();
        soldAmount.setText("50");
        soldAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel sold = new JPanel();
        sold.setLayout(new GridBagLayout());

        sold.add(soldLabel);
        sold.add(soldAmount);

        JLabel totalProfitLabel = new JLabel();
        totalProfitLabel.setText("Profit: ");
        totalProfitLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel profitAmount = new JLabel();
        profitAmount.setText("50");
        profitAmount.setFont(new Font("Gilroy", Font.BOLD,80));

        JPanel profit = new JPanel();
        profit.setLayout(new GridBagLayout());

        profit.add(totalProfitLabel);
        profit.add(profitAmount);

        JLabel lossLabel = new JLabel();
        lossLabel.setText("Loss: ");
        lossLabel.setFont(new Font("Gilroy", Font.BOLD,20));

        JLabel  lossAmount = new JLabel();
        lossAmount.setText("50");
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

}
