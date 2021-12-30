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

        JButton addtocart = new JButton();
        addtocart.setText("ADD TO CART");
        addtocart.setForeground(Color.darkGray);
        addtocart.setBackground(Color.white);
        addtocart.setFocusable(false);
        addtocart.setBounds(300, 200, 130, 60);
        p1.add(addtocart);


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
                {"5", "e", "shirt", "300"},
                {"6", "f", "shirt", "300"},
                {"7", "g", "shirt", "300"},
                {"8", "h", "shirt", "300"},
                {"9", "i", "shirt", "300"},
        };

        JTable purchaseNow = new JTable(data, column_name);

        purchaseNow.setAutoCreateRowSorter(true); // sorting when clicked on the header
        purchaseNow.setEnabled(false); // disabling the editing
        purchaseNow.setRowHeight(35);

        JPanel tableP = new JPanel();
        tableP.setLayout(new BorderLayout(0,0));
        tableP.add(purchaseNow.getTableHeader(), BorderLayout.NORTH);
        tableP.add(purchaseNow, BorderLayout.CENTER);

        tableP.add(purchaseNow);
        add(tableP , BorderLayout.CENTER);

    }
}