package Model;

import java.sql.Date;

public class Customer extends User {
    private int customerNumber;
    private Date dateCreated;

    public Customer(String firstName, String lastName, int customerNumber, Date dateCreated) {
        super(firstName, lastName);
        this.customerNumber = customerNumber;
        this.dateCreated = dateCreated;
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

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", dateCreated=" + dateCreated +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
