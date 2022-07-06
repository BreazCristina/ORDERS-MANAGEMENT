package BusinessLogic;

import Model.Client;


/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class ClientValidator {


    public boolean validateID(int ID){

        if(ID >0)
            return true;

        else return false;
    }



    public boolean validateAge(int age){

        if(age < 5 || age > 110)
            return false;

        return true;
    }
    public boolean validateName(String name){

        if(name == "")
            return false;
        else if(name.matches("[ a-zA-Z]+") == false)
            return false;

        return true;
    }

    public boolean validateClient(Client client){

        if(validateID(client.getID()) == false)
            return false;
        else if(validateName(client.getFirstName()) == false)
            return false;
        else if(validateName(client.getLastName()) == false)
            return false;
        else if(validateAge(client.getAge()) == false)
            return false;
        return true;

    }



}