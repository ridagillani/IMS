package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {
    JPanel userPanel = new userWelcome();
    JPanel productPanel = new Product();
    JPanel inventoryPanel = new Inventory();
    JPanel transPanel = new Transactions();
    JPanel orderPanel = new Orders();

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

        JButton manage = new JButton();
        manage.setText("See Products");
        manage.setSize(125,60);
        manage.setForeground(Color.darkGray);
        manage.setBackground(Color.white);

        manage.addActionListener(e-> {
                    this.dispose();
                    showProd backmain = new showProd();
                });

        JButton stock = new JButton();
        stock.setText("Book Products");
        stock.setForeground(Color.darkGray);
        stock.setBackground(Color.white);

        JButton orders = new JButton();
        orders.setText("Check Cart");
        orders.setForeground(Color.darkGray);
        orders.setBackground(Color.white);


        JButton dashboard = new JButton();
        dashboard.setText("Dashboard");
        dashboard.setForeground(Color.darkGray);
        dashboard.setBackground(Color.white);

//        manage.addActionListener(new User.UserAction());
//        stock.addActionListener(new User.UserAction());
//        orders.addActionListener(new User.UserAction());
//        dashboard.addActionListener(new User.UserAction());
//

        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);
        navigation.add(manage);
        navigation.add(stock);
        navigation.add(orders);
        navigation.setBounds(200,200,400,30);

        header.add(dashLabel);
        header.add(navigation);
        add(header, BorderLayout.NORTH);
        add(userPanel, BorderLayout.CENTER);

    }

//    class UserAction implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getActionCommand().equalsIgnoreCase("See Products")) {
//                if (current == "dash")
//                {
//                    remove(dashPanel);
//                }
//
//                else if (current == "manage")
//                {
//                    remove(productPanel);
//                }
//
//                else if (current == "orders")
//                {
//                    remove(orderPanel);
//                }
//
//                else if (current == "stock")
//                {
//                    remove(inventoryPanel);
//                }
//
//                else if (current == "transactions")
//                {
//                    remove(transPanel);
//                }
//
//                add(productPanel, BorderLayout.CENTER);
//                current = "manage";
//                revalidate();
//                repaint();
//            }
//
//            else if (e.getActionCommand().equalsIgnoreCase("Check Stock"))
//            {
//                if (current == "dash")
//                {
//                    remove(dashPanel);
//                }
//
//                else if (current == "manage")
//                {
//                    remove(productPanel);
//                }
//
//                else if (current == "orders")
//                {
//                    remove(orderPanel);
//                }
//
//                else if (current == "stock")
//                {
//                    remove(inventoryPanel);
//                }
//
//                else if (current == "transactions")
//                {
//                    remove(transPanel);
//                }
//
//                add(inventoryPanel, BorderLayout.CENTER);
//                current = "stock";
//                revalidate();
//                repaint();
//            }
//
//            else if (e.getActionCommand().equalsIgnoreCase("Check Transactions"))
//            {
//                if (current == "dash")
//                {
//                    remove(dashPanel);
//                }
//
//                else if (current == "manage")
//                {
//                    remove(productPanel);
//                }
//
//                else if (current == "orders")
//                {
//                    remove(orderPanel);
//                }
//
//                else if (current == "stock")
//                {
//                    remove(inventoryPanel);
//                }
//
//                else if (current == "transactions")
//                {
//                    remove(transPanel);
//                }
//
//                add(transPanel, BorderLayout.CENTER);
//                current = "transactions";
//                revalidate();
//                repaint();
//            }
//
//            else if (e.getActionCommand().equalsIgnoreCase("Check Orders"))
//            {
//                if (current == "dash")
//                {
//                    remove(dashPanel);
//                }
//
//                else if (current == "manage")
//                {
//                    remove(productPanel);
//                }
//
//                else if (current == "orders")
//                {
//                    remove(orderPanel);
//                }
//
//                else if (current == "stock")
//                {
//                    remove(inventoryPanel);
//                }
//
//                else if (current == "transactions")
//                {
//                    remove(transPanel);
//                }
//
//                add(orderPanel, BorderLayout.CENTER);
//                current = "orders";
//                revalidate();
//                repaint();
//            }
//
//            else if (e.getActionCommand().equalsIgnoreCase("Dashboard"))
//            {
//                if (current == "dash")
//                {
//                    remove(dashPanel);
//                }
//
//                else if (current == "manage")
//                {
//                    remove(productPanel);
//                }
//
//                else if (current == "orders")
//                {
//                    remove(orderPanel);
//                }
//
//                else if (current == "stock")
//                {
//                    remove(inventoryPanel);
//                }
//
//                else if (current == "transactions")
//                {
//                    remove(transPanel);
//                }
//
//                add(dashPanel, BorderLayout.CENTER);
//                current = "dash";
//                revalidate();
//                repaint();
//            }
//        }
//    }
}