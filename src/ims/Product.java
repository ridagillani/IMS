package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product extends JPanel {
    JPanel productPanel = new ProductList();
    JPanel addProductPanel = new AddProduct();
    JPanel updateProductPanel = new UpdateProduct();

    String current = "view";

    public Product() {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        JButton New = new JButton();
        New.setText("Add New Product");
        New.setSize(125, 60);
        New.setForeground(Color.darkGray);
        New.setBackground(Color.white);
        New.setFocusable(false);

        JButton remove = new JButton();
        remove.setText("Remove Product");
        remove.setSize(125, 60);
        remove.setForeground(Color.darkGray);
        remove.setBackground(Color.white);
        remove.setFocusable(false);

        JButton update = new JButton();
        update.setText("Edit Product");
        update.setSize(125, 60);
        update.setForeground(Color.darkGray);
        update.setBackground(Color.white);
        update.setFocusable(false);

        JButton view = new JButton();
        view.setText("View Products");
        view.setSize(125, 60);
        view.setForeground(Color.darkGray);
        view.setBackground(Color.white);
        view.setFocusable(false);

        Container buttons = new Container();
        buttons.setLayout(new GridLayout(4, 1, 0, 10));
        buttons.setBounds(0, 0, 100, 100);

        view.addActionListener(new ProductAction());
        New.addActionListener(new ProductAction());
        update.addActionListener(new ProductAction());

        buttons.add(view);
        buttons.add(New);
        buttons.add(update);
        buttons.add(remove);

        // configuring the container to contain the table
        setLayout(new BorderLayout(0, 0));


        add(buttons, BorderLayout.WEST);
        add(productPanel, BorderLayout.CENTER);

    }

    class ProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Add New Product")) {
                if (current == "view") {
                    remove(productPanel);
                } else if (current == "add") {
                    remove(addProductPanel);
                } else if (current == "update") {
                    remove(updateProductPanel);
                }

                add(addProductPanel, BorderLayout.CENTER);
                current = "add";
                revalidate();
                repaint();
            }
            else if (e.getActionCommand().equalsIgnoreCase("Edit Product")) {
                if (current == "view") {
                    remove(productPanel);
                } else if (current == "add") {
                    remove(addProductPanel);
                } else if (current == "update") {
                    remove(updateProductPanel);
                }

                add(updateProductPanel, BorderLayout.CENTER);
                current = "update";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("View Products")) {
                if (current == "view") {
                    remove(productPanel);
                } else if (current == "add") {
                    remove(addProductPanel);
                } else if (current == "update") {
                    remove(updateProductPanel);
                }

                add(productPanel, BorderLayout.CENTER);
                current = "view";
                revalidate();
                repaint();
            }

        }
    }

}

class ProductList extends JPanel {
    ProductList () {
        setLayout(new BorderLayout(0,0));

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
        JTable productable = new JTable(data, column_name);

        // Table configurations
        productable.setAutoCreateRowSorter(true); // sorting when clicked on the header
        productable.setEnabled(false); // disabling the editing

        productable.setRowHeight(35);
        add(productable.getTableHeader(), BorderLayout.NORTH);
        add(productable, BorderLayout.CENTER);

    }
}

class AddProduct extends JPanel {
    public AddProduct()
    {
        setLayout(new BorderLayout());

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(5,2));

        JLabel name = new JLabel("Name");
        JTextField namef = new JTextField(20);

        JLabel description = new JLabel("Description");
        JTextField descriptionf = new JTextField();

        JLabel quantity = new JLabel("Quantity");
        JTextField quantityf = new JTextField(20);

        JLabel price = new JLabel("Price");
        JTextField pricef = new JTextField(20);

        updatePanel.add(name);
        updatePanel.add(namef);
        updatePanel.add(description);
        updatePanel.add(descriptionf);
        updatePanel.add(price);
        updatePanel.add(pricef);
        updatePanel.add(quantity);
        updatePanel.add(quantityf);

        add(updatePanel,BorderLayout.CENTER);
    }
}
class UpdateProduct extends JPanel {
    UpdateProduct() {
        JLabel n = new JLabel("Edit");
        add(n);
    }
}


