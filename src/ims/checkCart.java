package ims;

import javax.swing.*;
import java.awt.*;

public class checkCart extends JPanel {
    checkCart()
    {
        JPanel p2 = new JPanel();
        setBackground(Color.white);
        setLayout(new BorderLayout());


        JButton checkout = new JButton();
        checkout.setText("Confirm Order");
        checkout.setSize(125,60);
        checkout.setForeground(Color.darkGray);
        checkout.setBackground(Color.white);


        p2.add(checkout);
        add(p2, BorderLayout.SOUTH);


    }
}

