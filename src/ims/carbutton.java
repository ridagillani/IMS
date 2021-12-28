package ims;

import javax.swing.*;
import java.awt.*;

public class carbutton extends JFrame {
    JButton confirmOrder;
    JButton backbutton;
    JTextField textfield;
    public carbutton(){
        JPanel p1 = new JPanel(null);

        backbutton = new JButton("Go Back");
        backbutton.setBounds(300, 200, 130, 60);
        backbutton.addActionListener(e->{
            this.dispose();
            User backmain = new User();
        });
        backbutton.setBackground(Color.LIGHT_GRAY);
        confirmOrder = new JButton("Confirm My Order");
        confirmOrder.setBounds(50,200,180,60);
        confirmOrder.setBackground(Color.LIGHT_GRAY);

        p1.add(backbutton);
        p1.add(confirmOrder);

        add(p1);


        setTitle("Inventory Management System");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //       this.getContentPane().setBackground(Color.DARK_GRAY);

        ImageIcon image = new ImageIcon("shireeen.png");
        this.setIconImage(image.getImage());



    }

}
