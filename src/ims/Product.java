package ims;

import javax.swing.*;
import java.awt.*;

public class Product extends JPanel {

    public Product()
    {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        JButton New = new JButton();
        New.setText("Add New Product");
        New.setSize(125,60);
        New.setForeground(Color.darkGray);
        New.setBackground(Color.white);
        New.setFocusable(false);

        JButton remove = new JButton();
        remove.setText("Remove Product");
        remove.setSize(125,60);
        remove.setForeground(Color.darkGray);
        remove.setBackground(Color.white);
        remove.setFocusable(false);

        JButton update = new JButton();
        update.setText("Edit Product");
        update.setSize(125,60);
        update.setForeground(Color.darkGray);
        update.setBackground(Color.white);
        update.setFocusable(false);

        JButton view = new JButton();
        view.setText("View Products");
        view.setSize(125,60);
        view.setForeground(Color.darkGray);
        view.setBackground(Color.white);
        view.setFocusable(false);

        Container buttons = new Container();
        buttons.setLayout(new GridLayout(4,1,0,10));
        buttons.setBounds(0,0,100,100);

        buttons.add(New);
        buttons.add(remove);
        buttons.add(update);
        buttons.add(view);

        String[] column_name = {
                "Product ID",
                "Product Name",
                "Stock Quantity",
                "Price"
        };

        String[][] data = {
                {"1", "a", "shirt", "300"},
                {"2", "b", "shirt", "300"},
                {"3", "c", "shirt", "300"},
                {"4", "d", "shirt", "300"},
//                {"5", "e", "shirt", "male", "16", "20", "300"},
//                {"6", "f", "shirt", "male", "16", "20", "300"},
//                {"7", "g", "shirt", "male", "16", "20", "300"},
//                {"8", "h", "shirt", "male", "16", "20", "300"},
//                {"9", "i", "shirt", "male", "16", "20", "300"},
        };

        // then construct the table
        JTable productable = new JTable(data, column_name);

        // Table configurations
        productable.setAutoCreateRowSorter(true); // sorting when clicked on the header
        productable.setEnabled(false); // disabling the editing

        // configuring the container to contain the table
        setLayout(new BorderLayout(0,0));
        add(productable.getTableHeader(), BorderLayout.PAGE_START);
        add(productable, BorderLayout.CENTER);

//        String[] columns = {
//                "Product ID", "Product Name", "Stock Quantity", "Price"
//        };
//
//        String[][] data = {
//                { "0" , "1" , "2"} , { "Aseel Dates" , "Sohan Halwa" , "Desi Cashew" } ,
//                { "20 kg" , "15 kg" , "40 kg" } , { "Rs 7,000" , "Rs 15,000" , "Rs 20,000"  }
//        };

       // JTable table = new JTable(data , columns);
//        table.setBounds(30, 40, 800, 800);
//
        add(buttons,BorderLayout.WEST);
   //     add(table, BorderLayout.CENTER);

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


