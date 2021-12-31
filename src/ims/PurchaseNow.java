package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PurchaseNow extends JPanel
{
    PurchaseNow()
    {
        JPanel p1 = new JPanel();
        setBackground(Color.white);
        setLayout(new BorderLayout());


        JButton ac = new JButton();
        ac.setText("Add to Cart");
        ac.setSize(125,60);
        ac.setForeground(Color.darkGray);
        ac.setBackground(Color.white);


        p1.add(ac);
        add(p1, BorderLayout.SOUTH);


    }
}