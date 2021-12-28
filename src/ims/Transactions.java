package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JPanel
{

    public Transactions()
    {
        JLabel headT = new JLabel();
        headT.setText("Transaction Record");
        setSize(1280,720);
        setVisible(true);
        setLayout(new BorderLayout());
        add(headT);
    }

    class Back implements ActionListener {
        public void actionPerformed (ActionEvent e){

            }
        }
    }

