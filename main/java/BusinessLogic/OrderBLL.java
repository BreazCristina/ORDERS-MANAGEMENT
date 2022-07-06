package BusinessLogic;


import DataAcess.ClientDAO;
import DataAcess.OrderDAO;
import DataAcess.ProductDAO;
import Model.Client;
import Model.Orders;
import Model.Product;

import javax.swing.*;
import java.util.List;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */

public class OrderBLL {

    private final OrderDAO order;
    public OrderBLL() {
        order = new OrderDAO();
    }

    public List<Orders> getOrdersList(){
        return order.findAll();
    }

    public int[] getProducts() {

        ProductDAO produs= new ProductDAO();
        List<Product> lista = produs.findAll();
        int[] produse;

        produse = new int[lista.size()];
        int i=0;
        for (Product c : lista) {
            produse[i]= c.getId();
            i++;
        }
        return produse;
    }

    public JTable createTable(){
        return order.createTable();
    }

    public int[] getClients() {
        ClientDAO client= new ClientDAO();
        List<Client> lista = client.findAll();
        int[] clienti;
        clienti = new int[lista.size()];
        int i=0;
        for (Client c : lista) {
            clienti[i]= c.getID();
            i++;
        }
        return clienti;
    }


    public void delete(String id) {
        int id1;


        try {
            id1 = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        Orders ord = order.findById(id1);
        if (ord!=null) {

            int quantity = ord.getQuantity();
            int productID = ord.getProductID();

            ProductDAO product = new ProductDAO();
            Product product1 = product.findById(productID);

            int productStock = product1.getStock();
            product1.setStock(productStock + quantity);
            product.update(product1);
            order.delete(ord);
        } else
            JOptionPane.showMessageDialog(null, " Order inexistent! ");
    }

    public void insert(String ID, int clientID, int  productID, int quantity){
        ProductDAO product = new ProductDAO();
        Product product1 = product.findById(productID);

        int orderID =0;
        try{
            orderID = Integer.parseInt(ID);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Bad input");
            return;
        }
        int stock1=product1.getStock();
        if(quantity < stock1){
            product1.setStock(product1.getStock() - quantity);
            product.update(product1);

            Orders order1 = new Orders(orderID,clientID,productID,quantity);
            order.insert(order1);
        }else{
            JOptionPane.showMessageDialog(null, "Not enough quantity!");

        }
    }

    public void update(String id, String quantity) {
        int q1;
        int id1;
        try {

            q1=Integer.parseInt(quantity);
            id1=Integer.parseInt(id);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        Orders orderUp = order.findById(id1);
        int clientID = orderUp.getClientID();
        int productID = orderUp.getProductID();
        int quantityU = orderUp.getQuantity();


        ProductDAO product = new ProductDAO();
        Product product1 = product.findById(productID);

        int currStock = product1.getStock();
        if (currStock + quantityU-q1>=0) {
            product1.setStock(currStock + quantityU - q1);
            product.update(product1);
            Orders myOrder = new Orders(id1, clientID, productID, q1);
            order.update(myOrder);
        }else {
            JOptionPane.showMessageDialog(null, "Big quantity");
        }
    }


    public Orders findById(int id){
        return order.findById(id);
    }
}