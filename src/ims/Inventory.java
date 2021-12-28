package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JPanel {

    public Inventory()

    {
        JLabel heading = new JLabel();
        heading.setText("Stock");
        setSize(1280, 720);
        setVisible(true);
        setLayout(new BorderLayout());
        add(heading);

    }

    class Back implements ActionListener {
        public void actionPerformed (ActionEvent e){

            }
        }
    }
