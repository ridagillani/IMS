package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class User extends JFrame {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    FileHandling fileM = new FileHandling();

    int selectedRow;
    ArrayList<CartProduct> cart = new ArrayList<>();

    JPanel userPanel = new PurchaseNow();
    JPanel cartPanel = new checkCart();

    String current = "welcome";

    JButton logout = new JButton();
    JButton cartB = new JButton();
    JButton dashboard = new JButton();


    public User()
    {
        setTitle("User Dashboard");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel header = new JPanel();
        header.setBackground(Color.DARK_GRAY);
        header.setLayout(new GridLayout(1,2,0,10));
        header.setPreferredSize(new Dimension(1280,100));

        JLabel heading = new JLabel();
        heading.setText("Inventory Management System");
        heading.setForeground(Color.WHITE);
        heading.setBackground(Color.darkGray);
        heading.setFont(new Font("Cinzel", Font.BOLD, 30));

        logout.setText("Exit");
        logout.setForeground(Color.darkGray);
        logout.setBackground(Color.white);
        logout.setFocusable(false);

        logout.addActionListener(e -> {
            dispose();
            new NewPage();});

        cartB.setText("Check Cart");
        cartB.setForeground(Color.darkGray);
        cartB.setBackground(Color.white);
        cartB.setFocusable(false);

        dashboard.setText("Dashboard");
        dashboard.setBackground(Color.gray);
        dashboard.setForeground(Color.WHITE);
        dashboard.setFocusable(false);

        cartB.addActionListener(new User.UserAction());
        dashboard.addActionListener(new User.UserAction());


        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);

        navigation.add(cartB);
        navigation.add(logout);
        navigation.setBounds(200,200,400,30);

        header.add(dashLabel);
        header.add(navigation);
        add(header, BorderLayout.NORTH);
        add(userPanel, BorderLayout.CENTER);

    }


    void placeOrder () {

        JFrame f = new JFrame("Order Placed");
        f.setBounds(300,300, 400,100);
        f.setLayout(new GridLayout(2,1));
        JLabel l = new JLabel("The order has been confirmed!");

        JButton b = new JButton("Okay");
        b.setFocusable(false);
        b.addActionListener(e -> f.dispose());

        f.add(l);
        f.add(b);
        f.setVisible(true);

        Order last;
        int id = 0;
        if (orders.size() > 0) {
            last = orders.get(orders.size() - 1);
            id = last.getOrder() + 1;
        }

        for (CartProduct cartProduct : cart) {
            Order n = new Order(id, cartProduct.getId(), cartProduct.getQuantity(), cartProduct.getTotalPrice(), cartProduct.getTotalCost());
            orders.add(n);

            for (Product product : products) {
                if (product.getPId() == cartProduct.getId()) {
                    product.setPQuantity(product.getPQuantity() - cartProduct.getQuantity());
                }
            }

        }

        orders = fileM.writeOrders(orders);
        products = fileM.writeProducts(products);

        cart = new ArrayList<>();

        switch (current) {
            case "welcome" -> {
                remove(userPanel);
                dashboard.setBackground(Color.white);
                dashboard.setForeground(Color.darkGray);
            }
            case "cart" -> {
                remove(cartPanel);
                cartB.setBackground(Color.white);
                cartB.setForeground(Color.darkGray);
            }
        }

        cartPanel = new checkCart();
        add(cartPanel, BorderLayout.CENTER);
        current = "cart";
        revalidate();
        repaint();

    }

    class UserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getActionCommand().equalsIgnoreCase("Check Cart"))
            {
                switch (current) {
                    case "welcome" -> {
                        remove(userPanel);
                        dashboard.setBackground(Color.white);
                        dashboard.setForeground(Color.darkGray);
                    }
                    case "cart" -> {
                        remove(cartPanel);
                        cartB.setBackground(Color.white);
                        cartB.setForeground(Color.darkGray);
                    }
                }

                cartPanel = new checkCart();
                add(cartPanel, BorderLayout.CENTER);
                cartB.setBackground(Color.gray);
                cartB.setForeground(Color.WHITE);
                current = "cart";
                revalidate();
                repaint();
            }


            else if (e.getActionCommand().equalsIgnoreCase("Dashboard"))
            {
                switch (current) {
                    case "welcome" -> {
                        remove(userPanel);
                        dashboard.setBackground(Color.white);
                        dashboard.setForeground(Color.darkGray);
                    }
                    case "cart" -> {
                        remove(cartPanel);
                        cartB.setBackground(Color.white);
                        cartB.setForeground(Color.darkGray);
                    }
                }

                add(userPanel, BorderLayout.CENTER);
                dashboard.setBackground(Color.gray);
                dashboard.setForeground(Color.WHITE);
                current = "welcome";
                revalidate();
                repaint();
            }
        }
    }


    public class checkCart extends JPanel {

        JTable cartable;

        checkCart()
        {
            JPanel p2 = new JPanel();
            setBackground(Color.white);
            setLayout(new BorderLayout());

            String[] column_name = {
                    "Product ID",
                    "Product Name",
                    "Product Quantity",
                    "Total Price"
            };

            String[][] data = new String[cart.size()][4];


            for (int i=0; i < cart.size(); i++) {
                String[] n = {Integer.toString(cart.get(i).getId()), cart.get(i).getName(), Integer.toString(cart.get(i).getQuantity()), Double.toString(cart.get(i).getTotalPrice())};
                data[i] = n;

            }

            cartable = new JTable(data, column_name);

            cartable.setAutoCreateRowSorter(true);

            JPanel viewPanel = new JPanel();
            viewPanel.setLayout(new BorderLayout());

            viewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,35));

            cartable.setRowHeight(35);
            viewPanel.add(cartable.getTableHeader(), BorderLayout.NORTH);
            viewPanel.add(cartable, BorderLayout.CENTER);


            JButton checkout = new JButton();
            checkout.setText("Confirm Order");
            checkout.setSize(125,60);
            checkout.setForeground(Color.darkGray);
            checkout.setBackground(Color.white);
            checkout.addActionListener(e -> placeOrder());


            p2.add(checkout);
            add(p2, BorderLayout.SOUTH);
            add(viewPanel, BorderLayout.CENTER);


        }

    }



    class PurchaseNow extends JPanel
    {

        Product selected;
        JTable productable;

        PurchaseNow()
        {
            JPanel p1 = new JPanel();
            setBackground(Color.white);
            setLayout(new BorderLayout());


            products = fileM.readProduct();
            orders = fileM.readOrders();


            String[] column_name = {
                    "Product ID",
                    "Product Name",
                    "Product Description",
                    "Product Category",
                    "Product Price"
            };

            String[][] data = new String[products.size()][6];


            for (int i=0; i < products.size(); i++) {
                String[] n = {Integer.toString(products.get(i).getPId()), products.get(i).getPname(), products.get(i).getDescription(), products.get(i).getCategory(), Double.toString(products.get(i).getPrice())};
                data[i] = n;

            }


            productable = new JTable(data, column_name) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            productable.setAutoCreateRowSorter(true);
            productable.setSelectionBackground(Color.LIGHT_GRAY);
            productable.setRowSelectionAllowed(true);
            productable.getSelectionModel().addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    selectedRow = Integer.parseInt(productable.getValueAt(productable.getSelectedRow(), 0).toString());
                }
            });


            JPanel viewPanel = new JPanel();
            viewPanel.setLayout(new BorderLayout());

            viewPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,35));

            productable.setRowHeight(35);
            viewPanel.add(productable.getTableHeader(), BorderLayout.NORTH);
            viewPanel.add(productable, BorderLayout.CENTER);


            JButton ac = new JButton();
            ac.setText("Add to Cart");
            ac.setSize(125,60);
            ac.setForeground(Color.darkGray);
            ac.setBackground(Color.white);
            ac.addActionListener(e -> addToCart());


            p1.add(ac);
            add(p1, BorderLayout.SOUTH);
            add(viewPanel, BorderLayout.CENTER);


        }

        void getProduct () {
            for (Product product : products) {
                if (product.getPId() == selectedRow) {
                    selected = product;
                    break;
                }
            }
        }

        boolean inCart () {
            for (CartProduct cartProduct : cart) {
                if (cartProduct.getId() == selected.getPId()) {
                    return true;
                }
            }
            return false;
        }

        void addToCart ()
        {
            JFrame f = new JFrame("Product Added To Cart");
            f.setBounds(300,300, 400,100);
            f.setLayout(new GridLayout(2,1));
            JLabel l = new JLabel("The product has been added!");

            JButton b = new JButton("Done");
            b.setFocusable(false);
            b.addActionListener(e -> f.dispose());


            f.add(l);
            f.add(b);
            f.setVisible(true);

            getProduct();

            if (inCart()) {
                for (CartProduct cartProduct : cart) {
                    if (cartProduct.getId() == selected.getPId()) {
                        cartProduct.addOne(selected.getPrice(), selected.getCost());
                        break;
                    }
                }
            } else {
                CartProduct n = new CartProduct(selected.getPId(), selected.getPname(), 1, selected.getPrice(), selected.getCost());
                cart.add(n);
            }
        }
    }
}