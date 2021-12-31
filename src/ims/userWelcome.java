package ims;

import javax.swing.*;
import java.awt.*;

public class userWelcome extends JPanel {
    public userWelcome() {
        String current = "dash";
        setBackground(Color.white);
        setLayout(new GridBagLayout());


        JLabel stockLabel = new JLabel();
        stockLabel.setText("Welcome to the program");
        stockLabel.setFont(new Font("Gilroy", Font.BOLD, 80));
        add(stockLabel);

            }
}