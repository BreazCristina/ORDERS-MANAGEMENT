package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class View extends JFrame {

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JScrollPane scrollPane;
    public View(GUI mainInterface) {


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 900, 700);
        this.getContentPane().setLayout(null);

        Font biggerFont = new Font("Times New Roman", Font.PLAIN, 18);

        btnNewButton = new JButton("Insert Client");

        btnNewButton.setBounds(10, 467, 189, 48);
        getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Delete Client");

        btnNewButton_1.setBounds(10, 526, 189, 53);
        getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Update Client");
        btnNewButton_2.setBounds(10, 590, 188, 48);
        getContentPane().add(btnNewButton_2);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(890, 655, -818, -476);
        getContentPane().add(scrollPane);

        btnNewButton_3 = new JButton("Back");
        btnNewButton_3.addActionListener(e-> {
            setVisible(false);
            mainInterface.setVisible(true);

        });
        btnNewButton_3.setBounds(743, 594, 160, 53);
        getContentPane().add(btnNewButton_3);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 25, 872, 405);
        getContentPane().add(scrollPane);

        textField = new JTextField();
        textField.setBounds(504, 467, 86, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(504, 509, 86, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(504, 554, 86, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(504, 604, 86, 20);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(443, 467, 46, 14);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("First Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(396, 510, 93, 14);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Last Name");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(396, 565, 79, 14);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Age");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(437, 598, 79, 29);
        getContentPane().add(lblNewLabel_3);


    }

    public String getText1() {
        return textField.getText();
    }


    public String getText2() {
        return textField_1.getText();
    }

    public String getText3() {
        return textField_2.getText();
    }

    public int getText4() {
        return Integer.parseInt(textField_3.getText());
    }


    public void insertListener(ActionListener a1){
        btnNewButton.addActionListener(a1);
    }


    public void deleteListener(ActionListener a2){
        btnNewButton_1.addActionListener(a2);
    }


    public void updateListener(ActionListener a3){
        btnNewButton_2.addActionListener(a3);
    }


    public JScrollPane getMyScrollPane(){
        return this.scrollPane;
    }
}