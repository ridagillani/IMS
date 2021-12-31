package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OrderScreen extends JPanel
{
    OrderScreen()
    {
        setBackground(Color.white);
        setLayout(new BorderLayout());

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

        // then construct the table
        JTable ordertable = new JTable(data, column_name);

        // Table configurations
        ordertable.setAutoCreateRowSorter(true); // sorting when clicked on the header
        ordertable.setEnabled(false); // disabling the editing
        ordertable.setRowHeight(35);

        JPanel tableP = new JPanel();
        tableP.setLayout(new BorderLayout(0,0));
        tableP.add(ordertable.getTableHeader(), BorderLayout.NORTH);
        tableP.add(ordertable, BorderLayout.CENTER);

        tableP.add(ordertable);
        add(tableP , BorderLayout.CENTER);

    }
}