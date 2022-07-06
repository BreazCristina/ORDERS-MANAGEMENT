package Presentation;

import java.sql.Connection;

import BusinessLogic.ClientBLL;

import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Connection.ConnectionFactory;
import Model.Client;
import Model.Orders;
import Model.Product;

import javax.swing.*;
import java.io.*;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class Controller {


    private final GUI GUI;
    private final View clientInterface;
    private final ProductInterface productInterface;
    private final OrderInterface orderInterface;
    private final ClientBLL client;
    //  private final OrderBLL order;
    private final ProductBLL product;
    private final OrderBLL order;

    public Controller() {

        GUI = new GUI();
        clientInterface = new View(GUI);
        productInterface = new ProductInterface(GUI);
        orderInterface = new OrderInterface(GUI);

        // orderInterface = new OrderInterface(userInterface);

        client = new ClientBLL();
        product = new ProductBLL();
        order = new OrderBLL();

        GUI.setVisible(true);
        // initializeUserInterfaceButtons();

        GUI.clientTableListener(e -> {
            GUI.setVisible(false);
            JTable x = client.createTable();
            clientInterface.getMyScrollPane().setViewportView(x);
            clientInterface.setVisible(true);
        });


        GUI.ordersTableListener(e -> {
            GUI.setVisible(false);
            int[] clienti;
            int[] produse;
            orderInterface.getComboBox().removeAllItems();
            orderInterface.getComboBox_1().removeAllItems();
            produse = order.getProducts();
            clienti = order.getClients();

            for (int item : clienti) {
                orderInterface.getComboBox().addItem(item);
            }
            for (int j : produse) {
                orderInterface.getComboBox_1().addItem(j);
            }
            JTable x = order.createTable();
            orderInterface.getMyScrollPane().setViewportView(x);
            orderInterface.setVisible(true);
        });


        GUI.productTableListener(e -> {
            GUI.setVisible(false);
            JTable x = product.createTable();
            productInterface.getMyScrollPane().setViewportView(x);
            productInterface.setVisible(true);
        });

        clientInterface.updateListener(e -> {

            String s1 = clientInterface.getText1();
            String s2 = clientInterface.getText2();
            String s3 = clientInterface.getText3();
            int s4 = clientInterface.getText4();
            client.UpdateClient(s1, s2, s3, s4);
            JTable x = client.createTable();
            clientInterface.getMyScrollPane().setViewportView(x);
            clientInterface.setVisible(true);
            ;
        });

        clientInterface.insertListener(e -> {
            client.insertNewClient(clientInterface.getText1(), clientInterface.getText2(), clientInterface.getText3(), clientInterface.getText4());
            JTable x = client.createTable();
            clientInterface.getMyScrollPane().setViewportView(x);
            clientInterface.setVisible(true);
            ;
        });

        clientInterface.deleteListener(e -> {
            client.delete(clientInterface.getText1());
            JTable x = client.createTable();
            clientInterface.getMyScrollPane().setViewportView(x);
            clientInterface.setVisible(true);
            ;
        });

        productInterface.updateListener(e -> {
            product.update(productInterface.getText1(), productInterface.getText2(), productInterface.getText3(), productInterface.getText4());
            JTable x = product.createTable();
            productInterface.getMyScrollPane().setViewportView(x);
            productInterface.setVisible(true);
        });

        productInterface.insertListener(e -> {


            product.insertNewProduct(productInterface.getText1(), productInterface.getText2(), Integer.parseInt(productInterface.getText3()), Integer.parseInt(productInterface.getText4()));
            JTable x = product.createTable();
            productInterface.getMyScrollPane().setViewportView(x);
            productInterface.setVisible(true);
        });

        productInterface.deleteListener(e -> {
            product.delete(productInterface.getText1());
            JTable x = product.createTable();
            productInterface.getMyScrollPane().setViewportView(x);
            productInterface.setVisible(true);
        });

        orderInterface.deleteListener(e -> {
            order.delete(orderInterface.getText1());
            JTable x = order.createTable();
            orderInterface.getMyScrollPane().setViewportView(x);
            orderInterface.setVisible(true);
        });

        orderInterface.insertListener(e -> {
            order.insert(orderInterface.getText1(), orderInterface.getText2(), orderInterface.getText3(), Integer.parseInt(orderInterface.getText4()));
            JTable x = order.createTable();
            orderInterface.getMyScrollPane().setViewportView(x);
            orderInterface.setVisible(true);
        });


        orderInterface.updateListener(e -> {
            order.update(orderInterface.getText1(), orderInterface.getText4());
            JTable x = order.createTable();
            orderInterface.getMyScrollPane().setViewportView(x);
            orderInterface.setVisible(true);
        });

        orderInterface.facturaListener(e-> {

            File f1 = new File("factura.txt");
            FileOutputStream i = null;
            try {
                i = new FileOutputStream(f1);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            OutputStreamWriter o = new OutputStreamWriter(i);
            Writer w = new BufferedWriter(o);
            StringBuilder builder = new StringBuilder();

            Orders ord = order.findById(Integer.parseInt(orderInterface.getText1()));
            builder.append("Order : " + ord.getId() + "\n");

            int prodID= ord.getProductID();
            int clID = ord.getClientID();

            Client currCl = client.searchByID(clID);
            if (currCl != null)
                builder.append("Name : " + currCl.getFirstName() + " " +currCl.getLastName() + "\n");

            Product currPr = product.searchByID(prodID);
            if (currPr != null)
                builder.append("Product : " + currPr.getName() + "\n");
            builder.append("Quantity : " + ord.getQuantity() + "\n");
            builder.append("Total price : " + ord.getQuantity() * currPr.getPrice() + "\n\n");
            try {
                w.write(builder.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            builder.delete(0, builder.length());
            try {
                w.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}




