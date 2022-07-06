package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class GUI extends JFrame {


    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;



    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 630, 350);
        this.getContentPane().setLayout(null);

        Font biggerFont = new Font("Times New Roman", Font.PLAIN, 18);
        Font hugeFont = new Font("Times New Roman",Font.PLAIN,32);

        btnNewButton = new JButton("Show Clients");

        btnNewButton.setBounds(211, 38, 189, 48);
        getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Show Products");

        btnNewButton_1.setBounds(211, 97, 189, 53);
        getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Show Orders");
        btnNewButton_2.setBounds(211, 161, 188, 48);
        getContentPane().add(btnNewButton_2);


    }


    public void clientTableListener(ActionListener a1)
    {
        btnNewButton.addActionListener(a1);
    }

    public void productTableListener(ActionListener a2)
    {
        btnNewButton_1.addActionListener(a2);
    }

    public void ordersTableListener(ActionListener a3)
    {
        btnNewButton_2.addActionListener(a3);
    }


}