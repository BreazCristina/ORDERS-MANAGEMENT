package BusinessLogic;


import DataAcess.ProductDAO;
import Model.Product;

import javax.swing.*;


/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */

public class ProductBLL {

    ProductDAO productDAO;

    ProductValidator productValidator;

    public ProductBLL() {
        productDAO = new ProductDAO();
        productValidator = new ProductValidator();
    }

    public Product searchByID(int ID){

        return productDAO.findById(ID);
    }




    public void insertNewProduct(String ID, String name, int price, int stock)  {


        boolean validID = true;
        int productID = 0;

        try {
            productID = Integer.parseInt(ID);
        } catch (Exception e) {
            validID = false;
            JOptionPane.showMessageDialog(null, "Bad ID!");

        }
        if (validID == true) {
           ProductValidator PV = new ProductValidator();
            Product product = new Product(productID,name,price,stock);

            if (PV.validateProduct(product) == true) {
                Product myNewProduct = new Product(productID, name,price,stock);
                productDAO.insert(myNewProduct);
            } else
                JOptionPane.showMessageDialog(null, "Bad input!");
        }
    }

    public JTable createTable(){
        return productDAO.createTable();
    }

    public void delete(String id) {
        int idD;
        try {
            idD = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        Product pDelete = productDAO.findById(idD);
        if (pDelete!=null) {
            productDAO.delete(pDelete);
        } else
            JOptionPane.showMessageDialog(null, "Product inexistent! ");
    }


    public void update(String id, String name, String productPrice, String productStock) {
        int idU , price, stock;
        try {
            idU=Integer.parseInt(id);
            price=Integer.parseInt(productPrice);
            stock=Integer.parseInt(productStock);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        Product product = new Product(idU,name,price,stock);
        if (productValidator.validateProduct(product)) {
            Product newP = productDAO.findById(idU);
            newP.setName(name);
            newP.setStock(stock);
            newP.setPrice(price);
            productDAO.update(newP);
        }
    }
}