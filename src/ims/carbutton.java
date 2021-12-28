package ims;

import javax.swing.*;
import java.awt.*;

public class carbutton extends JPanel {
    JButton confirmOrder;
    JButton backbutton;
    JTextField textfield;
    public carbutton(){
        JPanel p1 = new JPanel(null);

        backbutton = new JButton("Go Back");
        backbutton.setBounds(300, 200, 130, 60);
        backbutton.addActionListener(e->{
            User backmain = new User();
        });
        backbutton.setBackground(Color.LIGHT_GRAY);
        confirmOrder = new JButton("Confirm My Order");
        confirmOrder.setBounds(50,200,180,60);
        confirmOrder.setBackground(Color.LIGHT_GRAY);

        p1.add(backbutton);
        p1.add(confirmOrder);

        add(p1);


    }

}
