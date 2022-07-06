package Model;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class Orders {


    private int id;
    private int clientID;
    private int productID;
    private int quantity;

    public Orders(){
    }


    public Orders(int orderID, int clientID, int productID, int quantity) {
        this.id = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + id +
                ", clientID=" + clientID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}