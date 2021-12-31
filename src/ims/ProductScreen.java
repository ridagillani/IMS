package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductScreen extends JPanel {
    JPanel productPanel = new ProductList();
    JPanel addProductPanel = new AddProduct();
    JPanel updateProductPanel = new UpdateProduct();

    String current = "view";

    ArrayList<Product> products = new ArrayList<>();
    fileHandling file = new fileHandling();

    public ProductScreen() {
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

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4, 1, 0, 50));
        buttons.setBounds(0, 0, 100, 100);

        view.addActionListener(new ProductAction());
        New.addActionListener(new ProductAction());
        update.addActionListener(new ProductAction());

        buttons.add(view);
        buttons.add(New);
        buttons.add(update);
        buttons.add(remove);
        buttons.setBackground(Color.darkGray);
        buttons.setBorder(BorderFactory.createEmptyBorder(50,0,50,0));

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
        setLayout(new BorderLayout());

        JPanel viewPanel = new JPanel();
        viewPanel.setLayout(new BorderLayout());

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
        viewPanel.add(productable.getTableHeader(), BorderLayout.NORTH);
        viewPanel.add(productable, BorderLayout.CENTER);


        JLabel n1 = new JLabel("a");
        n1.setForeground(Color.darkGray);
        n1.setFont(new Font("Arial", Font.BOLD,30));

        JLabel n2 = new JLabel("a");
        n2.setForeground(Color.darkGray);
        n2.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n3 = new JLabel("a");
        n3.setForeground(Color.darkGray);
        n3.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n4 = new JLabel("a");
        n4.setForeground(Color.darkGray);
        n4.setFont(new Font("Arial", Font.BOLD,30));

        setBackground(Color.darkGray);

        add(viewPanel, BorderLayout.CENTER);
        add(n1, BorderLayout.NORTH);
        add(n2, BorderLayout.WEST);
        add(n3, BorderLayout.EAST);
        add(n4,BorderLayout.SOUTH);

    }
}



class AddProduct extends JPanel {
    public AddProduct()
    {
        setLayout(new BorderLayout());

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(6,1, 0, 0));

        JLabel name = new JLabel("Name");
        name.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField namef = new JTextField();

        JLabel description = new JLabel("Description");
        description.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField descriptionf = new JTextField();

        JLabel quantity = new JLabel("Quantity");
        quantity.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField quantityf = new JTextField(20);

        JLabel price = new JLabel("Price");
        price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField pricef = new JTextField(20);

        JLabel CategoryLabel = new JLabel("Category");
        CategoryLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

        String[] s1={"Technology","Grocery","Crockery","Clothing" , "Perfumes"};
        JComboBox j1=new JComboBox(s1);

        JButton add = new JButton();
        add.setText("Add");
        add.setBackground(Color.darkGray);
        add.setForeground(Color.white);

        JButton Cancel = new JButton();
        Cancel.setText("Cancel");
        Cancel.setBackground(Color.darkGray);
        Cancel.setForeground(Color.white);

        JPanel nameGroup = new JPanel();
        nameGroup.setLayout(new GridLayout(1, 2));
        nameGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        nameGroup.add(name);
        nameGroup.add(namef);

        JPanel descGroup = new JPanel();
        descGroup.setLayout(new GridLayout(1, 2));
        descGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        descGroup.add(description);
        descGroup.add(descriptionf);

        JPanel priceGroup = new JPanel();
        priceGroup.setLayout(new GridLayout(1, 2));
        priceGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        priceGroup.add(price);
        priceGroup.add(pricef);

        JPanel quanGroup = new JPanel();
        quanGroup.setLayout(new GridLayout(1, 2));
        quanGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        quanGroup.add(quantity);
        quanGroup.add(quantityf);

        JPanel catGroup = new JPanel();
        catGroup.setLayout(new GridLayout(1, 2));
        catGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        catGroup.add(CategoryLabel);
        catGroup.add(j1);

        JPanel buttGroup = new JPanel();
        buttGroup.setLayout(new GridLayout(1, 2));
        buttGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        buttGroup.add(add);
        buttGroup.add(Cancel);

        updatePanel.add(nameGroup);
        updatePanel.add(descGroup);
        updatePanel.add(priceGroup);
        updatePanel.add(quanGroup);
        updatePanel.add(catGroup);
        updatePanel.add(buttGroup);

        JLabel n1 = new JLabel("a");
        n1.setForeground(Color.darkGray);
        n1.setFont(new Font("Arial", Font.BOLD,30));

        JLabel n2 = new JLabel("a");
        n2.setForeground(Color.darkGray);
        n2.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n3 = new JLabel("a");
        n3.setForeground(Color.darkGray);
        n3.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n4 = new JLabel("a");
        n4.setForeground(Color.darkGray);
        n4.setFont(new Font("Arial", Font.BOLD,30));

        setBackground(Color.darkGray);


        add(updatePanel, BorderLayout.CENTER);
        add(n1, BorderLayout.NORTH);
        add(n2, BorderLayout.WEST);
        add(n3, BorderLayout.EAST);
        add(n4,BorderLayout.SOUTH);
    }
}


class UpdateProduct extends JPanel {
    UpdateProduct() {
        setLayout(new BorderLayout());

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(6,1, 0, 0));

        JLabel name = new JLabel("Name");
        name.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField namef = new JTextField();

        JLabel description = new JLabel("Description");
        description.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField descriptionf = new JTextField();

        JLabel quantity = new JLabel("Quantity");
        quantity.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField quantityf = new JTextField(20);

        JLabel price = new JLabel("Price");
        price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        JTextField pricef = new JTextField(20);

        JLabel CategoryLabel = new JLabel("Category");
        CategoryLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

        String[] s1={"Technology","Grocery","Crockery","Clothing" , "Perfumes"};
        JComboBox j1=new JComboBox(s1);

        JButton edit = new JButton();
        edit.setText("Update");
        edit.setBackground(Color.darkGray);
        edit.setForeground(Color.white);

        JButton Cancel = new JButton();
        Cancel.setText("Cancel");
        Cancel.setBackground(Color.darkGray);
        Cancel.setForeground(Color.white);

        JPanel nameGroup = new JPanel();
        nameGroup.setLayout(new GridLayout(1, 2));
        nameGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        nameGroup.add(name);
        nameGroup.add(namef);

        JPanel descGroup = new JPanel();
        descGroup.setLayout(new GridLayout(1, 2));
        descGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        descGroup.add(description);
        descGroup.add(descriptionf);

        JPanel priceGroup = new JPanel();
        priceGroup.setLayout(new GridLayout(1, 2));
        priceGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        priceGroup.add(price);
        priceGroup.add(pricef);

        JPanel quanGroup = new JPanel();
        quanGroup.setLayout(new GridLayout(1, 2));
        quanGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        quanGroup.add(quantity);
        quanGroup.add(quantityf);

        JPanel catGroup = new JPanel();
        catGroup.setLayout(new GridLayout(1, 2));
        catGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        catGroup.add(CategoryLabel);
        catGroup.add(j1);

        JPanel buttGroup = new JPanel();
        buttGroup.setLayout(new GridLayout(1, 2));
        buttGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        buttGroup.add(edit);
        buttGroup.add(Cancel);

        updatePanel.add(nameGroup);
        updatePanel.add(descGroup);
        updatePanel.add(priceGroup);
        updatePanel.add(quanGroup);
        updatePanel.add(catGroup);
        updatePanel.add(buttGroup);

        JLabel n1 = new JLabel("a");
        n1.setForeground(Color.darkGray);
        n1.setFont(new Font("Arial", Font.BOLD,30));

        JLabel n2 = new JLabel("a");
        n2.setForeground(Color.darkGray);
        n2.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n3 = new JLabel("a");
        n3.setForeground(Color.darkGray);
        n3.setFont(new Font("Arial", Font.BOLD,80));

        JLabel n4 = new JLabel("a");
        n4.setForeground(Color.darkGray);
        n4.setFont(new Font("Arial", Font.BOLD,30));

        setBackground(Color.darkGray);


        add(updatePanel, BorderLayout.CENTER);
        add(n1, BorderLayout.NORTH);
        add(n2, BorderLayout.WEST);
        add(n3, BorderLayout.EAST);
        add(n4,BorderLayout.SOUTH);
    }
}


