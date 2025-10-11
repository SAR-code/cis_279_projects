/*************************************************************
 * Program : Customer.java
 * Purpose : This file contains the class definition and implementation
 *           of the Customer Class. It contains attributes and methods
 *           required for the customer data
 *
 * Created : 10/10/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
public class Customer {

    // Declare private member variables
    private int customerNumber;
    private String lastName;
    private  String firstName;
    private int creditScore;

    // Declare default constructor
    public Customer(){
        this.customerNumber = 0;
        this.lastName = "";
        this.firstName = "";
        this.creditScore = 0;
    }

    // Declare a parameterized constructor
    public Customer (int customerNumber, String lastName,
                     String firstName, int creditScore)
    {

        this.customerNumber = customerNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.creditScore = creditScore;
    }

    // Declare getters and setters
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }


    public int getCustomerNumber() {
        return customerNumber;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }


    public int getCreditScore() {
        return creditScore;
    }
}
