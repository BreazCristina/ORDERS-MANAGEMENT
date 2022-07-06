package BusinessLogic;


import DataAcess.ClientDAO;
import Model.Client;

import javax.swing.*;


/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class ClientBLL {

    ClientDAO clientDAO;

    ClientValidator clientValidator;

    public ClientBLL() {
        clientDAO = new ClientDAO();
        clientValidator = new ClientValidator();
    }

    public Client searchByID(int ID){

        return clientDAO.findById(ID);
    }

    public JTable createTable(){
        return clientDAO.createTable();
    }


    public void insertNewClient(String ID, String firstName,String lastName, int age){
        boolean validID = true;
        int clientID = 0;
        try {
            clientID = Integer.parseInt(ID);
        } catch (Exception e) {
            validID = false;
            JOptionPane.showMessageDialog(null, "Bad ID!");
        }

        if (validID == true) {
            ClientValidator CV = new ClientValidator();
            Client myNewClient = new Client(clientID, firstName, lastName, age);

            if (CV.validateClient(myNewClient) == true) {
                clientDAO.insert(myNewClient);
            } else
                JOptionPane.showMessageDialog(null, "Bad input!");
        }

    }


    public void delete(String id) {
        int idD;
        try {
            idD = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        Client cDelete = clientDAO.findById(idD);
        if (cDelete!=null) {
            clientDAO.delete(cDelete);
        } else
            JOptionPane.showMessageDialog(null, " Client inexistent! ");
    }



    public void UpdateClient(String ID, String firstName,String lastName, int age)
    {
        int idU;
        try {
            idU=Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        Client client = new Client(idU,firstName,lastName,age);
        if (clientValidator.validateClient(client) == true) {
            Client myNewClient = searchByID(idU);
            myNewClient.setFirstName(firstName);
            myNewClient.setLastName(lastName);
            myNewClient.setAge(age);
            clientDAO.update(myNewClient);
        }

    }
}






