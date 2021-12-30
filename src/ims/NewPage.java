package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewPage extends JFrame
{

    private ButtonGroup buttons = new ButtonGroup();

    public NewPage()
    {

        setTitle("Inventory Management System");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1940,1041);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);


        JLabel label = new JLabel();
        label.setText("Inventory Management System");
        label.setBounds(390, 130, 1400, 120);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Cinzel", Font.BOLD, 30));
        panel.add(label);

        JButton user = new JButton();
        user.setText("User");
        user.setBounds(550,350,125,60);
        user.setBackground(Color.WHITE);
        user.setForeground(Color.darkGray);
        user.setFont(new Font("Cinzel", Font.BOLD, 15));
        user.setFocusable(false);

        panel.add(user);
        buttons.add(user);
        user.addActionListener(new Action());

        JButton admin = new JButton();
        admin.setText("Admin");
        admin.setBounds(550,250,125,60);
        admin.setBackground(Color.WHITE);
        admin.setForeground(Color.darkGray);
        admin.setFont(new Font("Cinzel", Font.BOLD, 15));
        admin.setFocusable(false);

        JButton exit = new JButton();
        exit.setText("EXIT");
        exit.setBounds(1100,600,125,60);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.darkGray);
        exit.setFont(new Font("Cinzel", Font.BOLD, 15));
        exit.setFocusable(false);
        exit.addActionListener(e -> {
            System.exit(0);
        });


        panel.add(admin);
        buttons.add(admin);
        panel.add(exit);

        admin.addActionListener(new Action());

        add(panel);

    }


    class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("User")) {
                new User();
                dispose();
            }

            else if (e.getActionCommand().equalsIgnoreCase("Admin"))
            {
                new Admin();
                dispose();
            }

        }
    }
}
