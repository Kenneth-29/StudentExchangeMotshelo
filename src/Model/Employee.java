package Model;

public class Employee extends User {

    private String username;
    private String email;
    private String physicalAddress;


    public Employee(String firstName, String lastName, String username, String email, String physicalAddress) {
        super(firstName, lastName);
        this.username = username;
        this.email = email;
        this.physicalAddress = physicalAddress;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
