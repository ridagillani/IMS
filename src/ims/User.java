package ims;

import javax.swing.*;
import java.awt.*;

public class User extends JFrame {
    JButton prodbutton;
    JButton carbutton;
    JButton bookbutton;
    JButton backbutton;
    public User()
    {




        JPanel panel = new JPanel(null);

        prodbutton = new JButton("Show products");
        bookbutton = new JButton("Book");
        carbutton = new JButton("Cart");
        backbutton = new JButton("Back");

        prodbutton.setBounds(50, 20, 130, 60);
        bookbutton.setBounds(300, 20, 130, 60);
        carbutton.setBounds(50, 200, 130, 60);
        backbutton.setBounds(300, 200, 130, 60);

        prodbutton.setBackground(Color.LIGHT_GRAY);
        prodbutton.addActionListener(e->{
            this.dispose();
            showProd showprod = new showProd();
        });
        bookbutton.addActionListener(e->{
            this.dispose();
            bookProd showprod = new bookProd();
        });
        carbutton.addActionListener(e-> {
            this.dispose();
            carbutton showprod = new carbutton();
        });
        backbutton.addActionListener(e->{
            this.dispose();
            NewPage main = new NewPage();
        });
        bookbutton.setBackground(Color.LIGHT_GRAY);
//        bookbutton.addActionListener(new myHandler());
        carbutton.setBackground(Color.LIGHT_GRAY);
//        carbutton.addActionListener(new myHandler());
        backbutton.setBackground(Color.LIGHT_GRAY);
//        backbutton.addActionListener(new myHandler());

        panel.add(prodbutton);
        panel.add(bookbutton);
        panel.add(carbutton);
        panel.add(backbutton);


        add(panel);

        setTitle("Inventory Management System");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.getContentPane().setBackground(Color.DARK_GRAY);

        ImageIcon image = new ImageIcon("shireeen.png");
        setIconImage(image.getImage());

    }
    }

