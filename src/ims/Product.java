package ims;

import javax.swing.*;
import java.awt.*;

public class Product extends JPanel {

    public Product()
    {
        setBackground(Color.blue);
        setLayout(new GridBagLayout());
        JLabel heading = new JLabel();
        heading.setText("Manage Products");
        heading.setForeground(Color.WHITE);
        heading.setBackground(Color.darkGray);
        heading.setFont(new Font("Cinzel", Font.BOLD, 30));
        add(heading);
//        setTitle("Manage Products");
//        setSize(1280, 720);
//        setVisible(true);
//        setResizable(false);
//        setLayout(new BorderLayout());
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        JPanel headerp = new JPanel();
//        headerp.setBackground(Color.darkGray);
//        headerp.setPreferredSize(new Dimension(1280,150));
//        add(headerp, BorderLayout.NORTH);
//
//        JButton back = new JButton();
//        back.setText("Back");
//        back.setBounds(530, 246, 125, 60);
//        back.setBackground(Color.WHITE);
//        back.setForeground(Color.darkGray);
//        back.setFont(new Font("Cinzel", Font.BOLD, 15));
//        add(back,BorderLayout.SOUTH);
//        back.addActionListener(new Back());

    }

//    class Back implements ActionListener {
//        public void actionPerformed (ActionEvent e){
//            if (e.getActionCommand().equalsIgnoreCase("Back")) {
//                new Dashboard();
////                dispose();
//            }
//        }
//    }
}
