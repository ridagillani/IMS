package ims;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class ProductScreen extends JPanel {

    ArrayList<Product> products = new ArrayList<Product>();
    fileHandling fileM = new fileHandling();

    int selectedRow;

    JButton remove = new JButton();

    JPanel productPanel = new ProductList();
    JPanel addProductPanel = new AddProduct();
    JPanel updateProductPanel = new UpdateProduct();


    String current = "view";

    public ProductScreen() {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        JButton New = new JButton();
        New.setText("Add New Product");
        New.setSize(125, 60);
        New.setForeground(Color.darkGray);
        New.setBackground(Color.white);
        New.setFocusable(false);

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
        remove.addActionListener(e -> removePopup());

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

    void removePopup () {
        JFrame f = new JFrame("Product Remove");
        f.setBounds(300,300, 400,130);
        f.setLayout(new GridLayout(2,1));
        JLabel l = new JLabel("Do you want to remove the product? ");

        JButton b = new JButton("Yes");
        JButton b2 = new JButton("No");

        b.addActionListener(e -> {
            removeProduct();
            f.dispose();
        });
        b2.addActionListener(e -> {f.dispose();});

        f.add(l);
        f.add(b);
        f.add(b2);
        f.show();

    }

    void removeProduct () {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPId() == selectedRow) {
                products.remove(i);
            }
        }

        products = fileM.writeProducts(products);


        if (current == "view") {
            remove(productPanel);
        } else if (current == "add") {
            remove(addProductPanel);
        } else if (current == "update") {
            remove(updateProductPanel);
        }

        productPanel = new ProductList();

        add(productPanel, BorderLayout.CENTER);
        current = "view";
        revalidate();
        repaint();
    }


    class ProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            products = fileM.readProduct();
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

                updateProductPanel = new UpdateProduct();
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

                productPanel = new ProductList();

                add(productPanel, BorderLayout.CENTER);
                current = "view";
                revalidate();
                repaint();
            }

        }
    }

    class ProductList extends JPanel {
        ProductList () {
            setLayout(new BorderLayout());

            JPanel viewPanel = new JPanel();
            viewPanel.setLayout(new BorderLayout());

            products = fileM.readProduct();


            String[] column_name = {
                    "Product ID",
                    "Product Name",
                    "Product Description",
                    "Stock Quantity",
                    "Product Category",
                    "Product Price",
                    "Product Cost"
            };

            String[][] data = new String[products.size()][6];


            for (int i=0; i < products.size(); i++) {
                String[] n = {Integer.toString(products.get(i).getPId()), products.get(i).getPname(), products.get(i).getDescription(), Integer.toString(products.get(i).getPQuantity()), products.get(i).getCategory(), Double.toString(products.get(i).getPrice()), Double.toString(products.get(i).getCost())};
                data[i] = n;

            }

            JTable productable = new JTable(data, column_name) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            productable.setAutoCreateRowSorter(true);
            productable.setSelectionBackground(Color.LIGHT_GRAY);
            productable.setRowSelectionAllowed(true);
            productable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                   if (!event.getValueIsAdjusting()) {
                       selectedRow = Integer.parseInt(productable.getValueAt(productable.getSelectedRow(), 0).toString());
                   }
                }
            });



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
        JTextField namef = new JTextField();
        JTextField descriptionf = new JTextField();
        JTextField quantityf = new JTextField(20);
        JTextField pricef = new JTextField(20);
        JTextField costf = new JTextField(20);
        JComboBox j1;

        public AddProduct()
        {
            setLayout(new BorderLayout());

            JPanel updatePanel = new JPanel();
            updatePanel.setLayout(new GridLayout(7,1, 0, 0));

            JLabel name = new JLabel("Name");
            name.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));


            JLabel description = new JLabel("Description");
            description.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

            JLabel quantity = new JLabel("Quantity");
            quantity.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

            JLabel price = new JLabel("Price");
            price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));


            JLabel cost = new JLabel("Cost");
            price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));



            JLabel CategoryLabel = new JLabel("Category");
            CategoryLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));


            String[] s1 = {"Technology","Grocery","Crockery","Clothing" , "Perfumes"};
            j1 = new JComboBox(s1);


            JButton add = new JButton();
            add.setText("Add");
            add.setBackground(Color.darkGray);
            add.setForeground(Color.white);
            add.addActionListener(e -> addProduct(namef.getText(), descriptionf.getText(), quantityf.getText(), pricef.getText(), j1.getSelectedItem().toString(), costf.getText()));

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


            JPanel costGroup = new JPanel();
            costGroup.setLayout(new GridLayout(1, 2));
            costGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
            costGroup.add(cost);
            costGroup.add(costf);


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
            updatePanel.add(costGroup);
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

        void addProduct (String name, String description, String quantity, String price, String category, String cost) {
            Product last;
            int id = 0;
            if (products.size() > 0) {
                last = products.get(products.size() - 1);
                id = last.getPId() + 1;
            }

            Product newProd = new Product(id, name, description, Integer.parseInt(quantity), category, Double.parseDouble(price), Double.parseDouble(cost));

            products.add(newProd);

            products = fileM.writeProducts(products);

            namef.setText("");
            descriptionf.setText("");
            quantityf.setText("");
            pricef.setText("");


            JFrame f = new JFrame("Product Added");
            f.setBounds(300,300, 400,100);
            f.setLayout(new GridLayout(2,1));
            JLabel l = new JLabel("The product has been added");

            JButton b = new JButton("Okay");

            b.addActionListener(e -> {f.dispose();});

            f.add(l);
            f.add(b);
            f.show();


        }


    }


    class UpdateProduct extends JPanel {
        Product selected;

        UpdateProduct() {

            getProduct();

            setLayout(new BorderLayout());

            JPanel updatePanel = new JPanel();
            updatePanel.setLayout(new GridLayout(7,1, 0, 0));

            JLabel name = new JLabel("Name");
            name.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            JTextField namef = new JTextField();
            namef.setText(selected.getPname());

            JLabel description = new JLabel("Description");
            description.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            JTextField descriptionf = new JTextField();
            descriptionf.setText(selected.getDescription());

            JLabel quantity = new JLabel("Quantity");
            quantity.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            JTextField quantityf = new JTextField(20);
            quantityf.setText(Integer.toString(selected.getPQuantity()));

            JLabel price = new JLabel("Price");
            price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            JTextField pricef = new JTextField(20);
            pricef.setText(Double.toString(selected.getPrice()));

            JLabel cost = new JLabel("Cost");
            price.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
            JTextField costf = new JTextField(20);
            costf.setText(Double.toString(selected.getCost()));

            JLabel CategoryLabel = new JLabel("Category");
            CategoryLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

            String[] s1={"Technology","Grocery","Crockery","Clothing" , "Perfumes"};
            JComboBox j1=new JComboBox(s1);
            j1.setSelectedItem(selected.getCategory());

            JButton edit = new JButton();
            edit.setText("Update");
            edit.setBackground(Color.darkGray);
            edit.setForeground(Color.white);
            edit.addActionListener(e -> updateProduct(namef.getText(), descriptionf.getText(), quantityf.getText(), pricef.getText(), j1.getSelectedItem().toString(), costf.getText()));


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

            JPanel costGroup = new JPanel();
            costGroup.setLayout(new GridLayout(1, 2));
            costGroup.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
            costGroup.add(cost);
            costGroup.add(costf);

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
            updatePanel.add(costGroup);
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

        void getProduct () {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getPId() == selectedRow) {
                    selected = products.get(i);
                    break;
                }
            }
        }

        void updateProduct (String name, String description, String quantity, String price, String category, String cost) {
            selected.setPname(name);
            selected.setDescription(description);
            selected.setPQuantity(Integer.parseInt(quantity));
            selected.setPrice(Double.parseDouble(price));
            selected.setCategory(category);
            selected.setCost(Double.parseDouble(cost));

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getPId() == selected.getPId()) {
                    products.set(i, selected);
                }
            }

            products = fileM.writeProducts(products);


            JFrame f = new JFrame("Product Update");
            f.setBounds(300,300, 400,100);
            f.setLayout(new GridLayout(2,1));
            JLabel l = new JLabel("The product has been updated");

            JButton b = new JButton("Okay");

            b.addActionListener(e -> {f.dispose();});

            f.add(l);
            f.add(b);
            f.show();
        }

        }

}


