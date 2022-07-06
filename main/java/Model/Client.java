package Model;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 25, 2022
 */
public class Client {

    private int ID;
    private String firstName;
    private String lastName;
    private int age;

    public Client()
    {

    }
    public Client(int ID, String name1, String name2, int age) {
        this.ID = ID;
        this.firstName = name1;
        this.lastName = name2;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}