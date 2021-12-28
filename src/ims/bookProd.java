package ims;

import javax.swing.*;
import java.awt.*;

public class bookProd extends JFrame {
    JButton AddtoCart;
    JButton backbutton;
    public bookProd(){
        JPanel bookprod = new JPanel(null);

        backbutton = new JButton("Go Back");
        backbutton.setBounds(300, 200, 130, 60);
        backbutton.addActionListener(e->{
            this.dispose();
            User backmain = new User();
        });
        backbutton.setBackground(Color.LIGHT_GRAY);
        AddtoCart = new JButton("ADD TO CART");
        AddtoCart.setBounds(50,200,130,60);
        AddtoCart.setBackground(Color.LIGHT_GRAY);

        bookprod.add(backbutton);
        bookprod.add(AddtoCart);
        add(bookprod);

        setTitle("Inventory Management System");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //       this.getContentPane().setBackground(Color.darkGray);

        ImageIcon image = new ImageIcon("shireeen.png");
        setIconImage(image.getImage());
    }

}

