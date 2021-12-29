package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame
{
    JPanel dashPanel = new MainDash();
    JPanel productPanel = new Product();
    JPanel inventoryPanel = new Inventory();
    JPanel transPanel = new Transactions();
    JPanel orderPanel = new Orders();

    String current = "dash";

    public Dashboard()
    {
        setTitle("Admin Dashboard");
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
        manage.setText("Manage Products");
        manage.setSize(125,60);
        manage.setForeground(Color.darkGray);
        manage.setBackground(Color.white);
        manage.setFocusable(false);

        JButton stock = new JButton();
        stock.setText("Check Stock");
        stock.setForeground(Color.darkGray);
        stock.setBackground(Color.white);
        stock.setFocusable(false);

        JButton orders = new JButton();
        orders.setText("Check Orders");
        orders.setForeground(Color.darkGray);
        orders.setBackground(Color.white);
        orders.setFocusable(false);

<<<<<<< Updated upstream
        JButton backbutton = new JButton();
        backbutton.setText("Log Out");
        backbutton.setForeground(Color.darkGray);
        backbutton.setBackground(Color.white);
        backbutton.addActionListener(e -> {
            dispose();
            new NewPage();
        });
=======
        JButton transactions = new JButton();
        transactions.setText("Check Transactions");
        transactions.setForeground(Color.darkGray);
        transactions.setBackground(Color.white);
        transactions.setFocusable(false);
>>>>>>> Stashed changes

        JButton dashboard = new JButton();
        dashboard.setText("Dashboard");
        dashboard.setForeground(Color.darkGray);
        dashboard.setBackground(Color.white);
        dashboard.setFocusable(false);

        manage.addActionListener(new DashAction());
        backbutton.addActionListener(new DashAction());
        stock.addActionListener(new DashAction());
        orders.addActionListener(new DashAction());
        dashboard.addActionListener(new DashAction());

        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);
        navigation.add(manage);
        navigation.add(stock);
        navigation.add(orders);
        navigation.add(backbutton);
        navigation.setBounds(200,200,400,30);

        header.add(dashLabel);
        header.add(navigation);
        add(header, BorderLayout.NORTH);
        add(dashPanel, BorderLayout.CENTER);

    }

    class DashAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Manage Products")) {
                if (current == "dash")
                {
                    remove(dashPanel);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                }

                else if (current == "stock")
                {
                    remove(inventoryPanel);
                }


                add(productPanel, BorderLayout.CENTER);
                current = "manage";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Check Stock"))
            {
                if (current == "dash")
                {
                    remove(dashPanel);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                }

                else if (current == "stock")
                {
                    remove(inventoryPanel);
                }

                else if (current == "transactions")
                {
                    remove(transPanel);
                }

                add(inventoryPanel, BorderLayout.CENTER);
                current = "stock";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Check Transactions"))
            {
                if (current == "dash")
                {
                    remove(dashPanel);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                }

                else if (current == "stock")
                {
                    remove(inventoryPanel);
                }

                else if (current == "transactions")
                {
                    remove(transPanel);
                }

                add(transPanel, BorderLayout.CENTER);
                current = "transactions";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Check Orders"))
            {
                if (current == "dash")
                {
                    remove(dashPanel);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                }

                else if (current == "stock")
                {
                    remove(inventoryPanel);
                }

                else if (current == "transactions")
                {
                    remove(transPanel);
                }

                add(orderPanel, BorderLayout.CENTER);
                current = "orders";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Dashboard"))
            {
                if (current == "dash")
                {
                    remove(dashPanel);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                }

                else if (current == "stock")
                {
                    remove(inventoryPanel);
                }

                else if (current == "transactions")
                {
                    remove(transPanel);
                }

                add(dashPanel, BorderLayout.CENTER);
                current = "dash";
                revalidate();
                repaint();
            }
        }
    }
}


