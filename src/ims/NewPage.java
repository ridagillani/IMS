package ims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class NewPage extends JFrame
{

    public NewPage()
    {

        setTitle("Inventory Management System");
        setSize(1280,720);
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

        ButtonGroup buttons = new ButtonGroup();

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



        panel.add(admin);
        buttons.add(admin);

        admin.addActionListener(new Action());

        add(panel);
        setVisible(true);

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
