package ims;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class User extends JFrame {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    fileHandling fileM = new fileHandling();

    int selectedRow;
    ArrayList<CartProduct> cart = new ArrayList<>();

    JPanel userPanel = new PurchaseNow();
    JPanel seePanel = new PurchaseNow();

    JPanel cartPanel = new checkCart();


    String current = "welcome";

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

//        JButton manage = new JButton();
//        manage.setText("Purchase Now");
//        manage.setSize(125,60);
//        manage.setForeground(Color.darkGray);
//        manage.setBackground(Color.white);
//        manage.setFocusable(false);

        JButton logout = new JButton();
        logout.setText("Exit");
        logout.setForeground(Color.darkGray);
        logout.setBackground(Color.white);
        logout.addActionListener(e -> {
            dispose();
            new NewPage();
        });



        JButton orders = new JButton();
        orders.setText("Check Cart");
        orders.setForeground(Color.darkGray);
        orders.setBackground(Color.white);
        orders.setFocusable(false);


        JButton dashboard = new JButton();
        dashboard.setText("Dashboard");
        dashboard.setForeground(Color.darkGray);
        dashboard.setBackground(Color.white);
        dashboard.setFocusable(false);

//        manage.addActionListener(new User.UserAction());
        orders.addActionListener(new User.UserAction());
        dashboard.addActionListener(new User.UserAction());


        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);
//        navigation.add(manage);

        navigation.add(orders);
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
        f.setLayout(new GridBagLayout());
        JLabel l = new JLabel("Done");


        f.add(l);
        f.show();

        Order last;
        int id = 0;
        if (orders.size() > 0) {
            last = orders.get(orders.size() - 1);
            id = last.getOrder() + 1;
        }

        for (int i = 0; i < cart.size(); i++) {
            Order n = new Order(id, cart.get(i).getId(), cart.get(i).getQuantity(), cart.get(i).getTotalPrice(), cart.get(i).getTotalCost());
            orders.add(n);

        }
        orders = fileM.writeOrders(orders);

        cart = new ArrayList<>();

        if (current == "welcome")
        {
            remove(userPanel);
        }

        else if (current == "see")
        {
            remove(seePanel);
        }


        else if (current == "cart")
        {
            remove(cartPanel);
        }

        cartPanel = new checkCart();
        add(cartPanel, BorderLayout.CENTER);
        current = "cart";
        revalidate();
        repaint();

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }

        f.dispose();
    }

    class UserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

             if (e.getActionCommand().equalsIgnoreCase("Purchase Now"))
            {
                if (current == "welcome")
                {
                    remove(userPanel);
                }

                else if (current == "see")
                {
                   remove(seePanel);
                }


                else if (current == "cart")
                {
                    remove(cartPanel);
                }

                add(seePanel, BorderLayout.CENTER);
                current = "see";
                revalidate();
                repaint();



            }

            else if (e.getActionCommand().equalsIgnoreCase("Check Cart"))
            {
                if (current == "welcome")
                {
                    remove(userPanel);
                }

                else if (current == "see")
                {
                    remove(seePanel);
                }


                else if (current == "cart")
                {
                   remove(cartPanel);
                }

                cartPanel = new checkCart();
                add(cartPanel, BorderLayout.CENTER);
                current = "cart";
                revalidate();
                repaint();
            }


            else if (e.getActionCommand().equalsIgnoreCase("Dashboard"))
            {
                if (current == "welcome")
                {
                    remove(userPanel);
                }

                else if (current == "see")
                {
                    remove(seePanel);
                }

                else if (current == "cart")
                {
                   remove(cartPanel);
                }

                add(userPanel, BorderLayout.CENTER);
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
            productable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        selectedRow = Integer.parseInt(productable.getValueAt(productable.getSelectedRow(), 0).toString());
                    }
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
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getPId() == selectedRow) {
                    selected = products.get(i);
                    break;
                }
            }
        }

        boolean inCart () {
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getId() == selected.getPId()) {
                    return true;
                }
            }
            return false;
        }

        void addToCart () {
            JFrame f = new JFrame("Product Added to Cart");
            f.setBounds(300,300, 400,100);
            f.setLayout(new GridBagLayout());
            JLabel l = new JLabel("Done");


            f.add(l);
            f.show();

            getProduct();

            if (inCart()) {
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).getId() == selected.getPId()) {
                        cart.get(i).addOne(selected.getPrice(), selected.getCost());
                        break;
                    }
                }
            } else {
                CartProduct n = new CartProduct(selected.getPId(), selected.getPname(), 1, selected.getPrice(), selected.getCost());
                cart.add(n);
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }

            f.dispose();
        }
    }
}