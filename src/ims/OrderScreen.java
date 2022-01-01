package ims;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

class OrderScreen extends JPanel
{
    public ArrayList<Order> orders = new ArrayList<Order>();
    fileHandling fileM = new fileHandling();


    OrderScreen()
    {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        orders = fileM.readOrders();

        String[] column_name = {
                "Order Number",
                "Product ID",
                "Quantity",
                "Amount"
        };

        String[][] data = new String[orders.size()][4];


        for (int i=0; i < orders.size(); i++) {
            String[] n = {Integer.toString(orders.get(i).getOrder()), Integer.toString(orders.get(i).getPID()), Integer.toString(orders.get(i).getQuantity()), Double.toString(orders.get(i).getAmount())};
            data[i] = n;

        }


        JTable ordertable = new JTable(data, column_name);


        ordertable.setAutoCreateRowSorter(true);
        ordertable.setEnabled(false);
        ordertable.setRowHeight(35);

        JPanel tableP = new JPanel();
        tableP.setBorder(BorderFactory.createLineBorder(Color.darkGray,35));
        tableP.setLayout(new BorderLayout(0,0));
        tableP.add(ordertable.getTableHeader(), BorderLayout.NORTH);
        tableP.add(ordertable, BorderLayout.CENTER);

        tableP.add(ordertable);
        add(tableP , BorderLayout.CENTER);

    }
}