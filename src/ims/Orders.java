package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Orders extends JPanel
{
    Orders()
    {
        JLabel headO = new JLabel();
        headO.setText("Orders Record");
        setSize(1280,720);
        setVisible(true);
        setLayout(new BorderLayout());
        add(headO);

    }
    class Back implements ActionListener {
        public void actionPerformed (ActionEvent e){

        }
    }
}