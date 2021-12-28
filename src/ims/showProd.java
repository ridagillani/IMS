package ims;

import javax.swing.*;
import java.awt.*;

public class showProd extends JFrame {
    JButton backbutton;

    public showProd(){
        JPanel p1 = new JPanel(null);

        backbutton = new JButton("Go Back");
        backbutton.setBounds(300, 200, 130, 60);
        backbutton.addActionListener(e->{
            this.dispose();
            User backmain = new User();
        });
        backbutton.setBackground(Color.LIGHT_GRAY);

        p1.add(backbutton);
        add(p1);

        setTitle("Inventory Management System");
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.getContentPane().setBackground(Color.DARK_GRAY);

        ImageIcon image = new ImageIcon("shireeen.png");
        this.setIconImage(image.getImage());



    }
}


