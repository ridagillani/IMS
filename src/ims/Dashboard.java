package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame
{
    JPanel dashPanel = new MainDash();
    JPanel productPanel = new ProductScreen();
    JPanel orderPanel = new OrderScreen();

    JButton dashboard = new JButton();
    JButton manage = new JButton();
    JButton orders = new JButton();

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


        manage.setText("Manage Products");
        manage.setSize(125,60);
        manage.setForeground(Color.darkGray);
        manage.setBackground(Color.white);
        manage.setFocusable(false);


        orders.setText("Check Orders");
        orders.setForeground(Color.darkGray);
        orders.setBackground(Color.white);
        orders.setFocusable(false);


        JButton backbutton = new JButton();
        backbutton.setText("Log Out");
        backbutton.setForeground(Color.darkGray);
        backbutton.setBackground(Color.white);
        backbutton.setFocusable(false);
        backbutton.addActionListener(e -> {
            dispose();
            new NewPage();
        });



        dashboard.setText("Dashboard");
        dashboard.setForeground(Color.darkGray);
        dashboard.setBackground(Color.white);
        dashboard.setFocusable(false);

        manage.addActionListener(new DashAction());
        orders.addActionListener(new DashAction());
        dashboard.addActionListener(new DashAction());

        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);
        navigation.add(manage);
        navigation.add(orders);
        navigation.add(backbutton);
        navigation.setBounds(200,200,400,30);

        header.add(dashLabel);
        header.add(navigation);
        add(header, BorderLayout.NORTH);
        add(dashPanel, BorderLayout.CENTER);
        dashboard.setBackground(Color.gray);
        dashboard.setForeground(Color.WHITE);
        current = "dash";

    }

    class DashAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Manage Products")) {
                if (current == "dash")
                {
                    remove(dashPanel);
                    dashboard.setBackground(Color.white);
                    dashboard.setForeground(Color.darkGray);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                    manage.setBackground(Color.white);
                    manage.setForeground(Color.darkGray);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                    orders.setBackground(Color.white);
                    orders.setForeground(Color.darkGray);
                }


                add(productPanel, BorderLayout.CENTER);
                manage.setBackground(Color.gray);
                manage.setForeground(Color.WHITE);
                current = "manage";
                revalidate();
                repaint();
            }


            else if (e.getActionCommand().equalsIgnoreCase("Check Orders"))
            {

                if (current == "dash")
                {
                    remove(dashPanel);
                    dashboard.setBackground(Color.white);
                    dashboard.setForeground(Color.darkGray);
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                    manage.setBackground(Color.white);
                    manage.setForeground(Color.darkGray);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                    orders.setBackground(Color.white);
                    orders.setForeground(Color.darkGray);
                }

                add(orderPanel, BorderLayout.CENTER);
                orders.setBackground(Color.gray);
                orders.setForeground(Color.WHITE);
                current = "orders";
                revalidate();
                repaint();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Dashboard"))
            {
                if (current == "dash")
                {
                    remove(dashPanel);
                    dashboard.setBackground(Color.white);
                    dashboard.setForeground(Color.darkGray);
                    System.out.println("Working");
                }

                else if (current == "manage")
                {
                    remove(productPanel);
                    manage.setBackground(Color.white);
                    manage.setForeground(Color.darkGray);
                }

                else if (current == "orders")
                {
                    remove(orderPanel);
                    orders.setBackground(Color.white);
                    orders.setForeground(Color.darkGray);
                }

                add(dashPanel, BorderLayout.CENTER);
                dashboard.setBackground(Color.gray);
                dashboard.setForeground(Color.WHITE);
                current = "dash";
                revalidate();
                repaint();
            }

        }
    }
}


