package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {
    JPanel userPanel = new userWelcome();
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

        JButton manage = new JButton();
        manage.setText("Purchase Now");
        manage.setSize(125,60);
        manage.setForeground(Color.darkGray);
        manage.setBackground(Color.white);

        JButton logout = new JButton();
        logout.setText("Exit");
        logout.setForeground(Color.darkGray);
        logout.setBackground(Color.white);
        logout.addActionListener(e -> {
            new NewPage();
        });



        JButton orders = new JButton();
        orders.setText("Check Cart");
        orders.setForeground(Color.darkGray);
        orders.setBackground(Color.white);


        JButton dashboard = new JButton();
        dashboard.setText("Dashboard");
        dashboard.setForeground(Color.darkGray);
        dashboard.setBackground(Color.white);

        manage.addActionListener(new User.UserAction());
        orders.addActionListener(new User.UserAction());
        dashboard.addActionListener(new User.UserAction());


        Container dashLabel = new Container();
        dashLabel.setLayout(new GridBagLayout());
        dashLabel.add(heading);

        Container navigation = new Container();
        navigation.setLayout(new GridBagLayout());
        navigation.add(dashboard);
        navigation.add(manage);

        navigation.add(orders);
        navigation.add(logout);
        navigation.setBounds(200,200,400,30);

        header.add(dashLabel);
        header.add(navigation);
        add(header, BorderLayout.NORTH);
        add(userPanel, BorderLayout.CENTER);

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

                //add(cartPanel, BorderLayout.CENTER);
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
}