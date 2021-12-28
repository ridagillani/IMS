package ims;

import javax.swing.*;
import java.awt.*;

public class Product extends JPanel {

    public Product()
    {
        setBackground(Color.white);

        JButton New = new JButton();
        New.setText("Add New Product");
        New.setSize(125,60);
        New.setForeground(Color.darkGray);
        New.setBackground(Color.white);

        JButton remove = new JButton();
        remove.setText("Remove Product");
        remove.setSize(125,60);
        remove.setForeground(Color.darkGray);
        remove.setBackground(Color.white);

        JButton update = new JButton();
        update.setText("Edit Product");
        update.setSize(125,60);
        update.setForeground(Color.darkGray);
        update.setBackground(Color.white);

        add(New);
        add(remove);
        add(update);

    }

//    class Back implements ActionListener {
//        public void actionPerformed (ActionEvent e){
//            if (e.getActionCommand().equalsIgnoreCase("Back")) {
//                new Dashboard();
////                dispose();
//            }
//        }
//    }
}
