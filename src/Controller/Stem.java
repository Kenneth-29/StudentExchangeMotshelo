package Controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import DbConnection.*;
import View.CustomerLogIn;
import View.LogIn;

public class Stem {
    private static PreparedStatement prst;
    private static ResultSet rs;
    private static Connection conn;

    public static void main(String[] args) throws SQLException {

    }
    public static ResultSet loginUser(String username,String password,String type) throws SQLException{
        conn = JDBC.getConnection();
        String query = "SELECT `username`, `password`,`type` FROM `Employee` WHERE username=? and password=? and type=?";
        prst =conn.prepareStatement(query);
        prst.setString(1, username);
        prst.setString(2, password);
        prst.setString(3, type);
        rs=prst.executeQuery();

        return rs;
    }
    public static ResultSet loginCustomers(int customerNumber,String password) throws SQLException{
        conn = JDBC.getConnection();
        String query = "SELECT `customernumber`,`password` FROM `customer` WHERE customernumber=? and password=?";
        prst =conn.prepareStatement(query);
        prst.setInt(1, customerNumber);
        prst.setString(2, password);
        rs=prst.executeQuery();

        return rs;
    }

    public static void customerDetails(String firstName, String lastName, int customerNumber, Date dateCreated) throws SQLException{
        Customer customer = new Customer(firstName,lastName,customerNumber,dateCreated);
        addCustomerDetails(customer);

    }
    public static void addCustomerDetails(Customer customer) throws SQLException{
        conn = JDBC.getConnection();
        String query = "INSERT INTO `customer` (`customernumber`, `firstname`, `lastname`, `date`, `password`) VALUES (?, ?, ?, ?, 'password')";
        prst =conn.prepareStatement(query);
        prst.setInt(1, customer.getCustomerNumber());
        prst.setString(2, customer.getFirstName());
        prst.setString(3, customer.getLastName());
        prst.setDate(4, customer.getDateCreated());
        prst.executeUpdate();
    }
    public static void updateCustomerDetails(int customernumber,String firstname,String lastname,Date date) throws SQLException{
        conn = JDBC.getConnection();
        String query = "update customer set firstname =?,lastname=?,date=? where customernumber=?";
        prst =conn.prepareStatement(query);
        prst.setString(1,firstname);
        prst.setString(2, lastname);
        prst.setDate(3, date);
        prst.setInt(4, customernumber);
        prst.executeUpdate();
    }
    public static void deleteCustomerDetails(int customernumber) throws SQLException{
        conn = JDBC.getConnection();
        String query = "delete from customer where customernumber=?";
        prst =conn.prepareStatement(query);
        prst.setInt(1, customernumber);
        prst.executeUpdate();
    }
    public ArrayList<Customer> listCustomers() throws SQLException{
        conn = JDBC.getConnection();
        String query = "Select firstname, lastname,customernumber, date FROM Customer";
        prst = conn.prepareStatement(query);
        rs = prst.executeQuery();
        ArrayList<Customer> list = new ArrayList<>();
        while(rs.next()){

            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            int customernumber = rs.getInt("customernumber");
            Date date = rs.getDate("date");

            System.out.println("CustomerName: " + customernumber);
            System.out.println("First Name: " + firstname);
            System.out.println("Last Name: " + lastname);
            System.out.println("Date: " + date);

            Customer cus = new Customer(firstname,lastname,customernumber,date);
            list.add(cus);

        }
        rs.close();
        return list;
    }
    public ArrayList<Employee> listEmployee() throws SQLException{
        conn = JDBC.getConnection();
        String query = "SELECT firstname, lastname,username , email, physicaladdress from Employee";
        prst = conn.prepareStatement(query);
        rs = prst.executeQuery();
        ArrayList<Employee> list =new ArrayList<>();
        while(rs.next()){
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String physicaladdress = rs.getString("physicaladdress");

            System.out.println("First Name: "+ firstname);
            System.out.println("Last Name: " + lastname);
            System.out.println("Email: " + email);
            System.out.println("Physical Address: " + physicaladdress);

            Employee emp = new Employee(firstname, lastname, username,email, physicaladdress);
            list.add(emp);
        }
        rs.close();
        return list;
    }

    public static void employeeDetails(String username, String firstname, String lastname,String email, String physicalAddress, String type) throws SQLException{
        Employee employee = new Employee(username,firstname,lastname,email,physicalAddress);
        addEmployeeDetails(employee,type);

    }
    public static void addEmployeeDetails(Employee employee,String type) throws SQLException{
        conn = JDBC.getConnection();
        String query = "INSERT INTO `Employee` (`username`, `password`, `email`, `firstname`, `surname`, `physicalAddress`, `type`) VALUES (?, 'password', ?, ?, ?, ?, ?)";
        prst =conn.prepareStatement(query);
        prst.setString(1, employee.getUsername());
        prst.setString(2, employee.getFirstName());
        prst.setString(3, employee.getLastName());
        prst.setString(4, employee.getEmail());
        prst.setString(5, employee.getPhysicalAddress());
        prst.setString(6, type);
        prst.executeUpdate();
    }
    public static void updateEmpDetails(String username, String firstname, String lastname,String email, String physicalAddress, String usertype) throws SQLException{
        conn = JDBC.getConnection();
        String query = "UPDATE `Employee` SET `firstname`=?,`surname`=?,`email`=?,`physicalAddress`=?,`usertype`=? WHERE `username`=?";
        prst =conn.prepareStatement(query);
        prst.setString(1, firstname);
        prst.setString(2, lastname);
        prst.setString(3,email);
        prst.setString(4, physicalAddress);
        prst.setString(5, usertype);
        prst.setString(6, username);
        prst.executeUpdate();
    }
    public static void deleteEmpDetails(String username) throws SQLException{
        conn = JDBC.getConnection();
        String query = "delete from employee where username=?";
        prst =conn.prepareStatement(query);
        prst.setString(1, username);
        prst.executeUpdate();
    }
    public static void faciliateLoan(int customernumber,String firstname,String lastname,Double loanAmount,Date date,int daysDue,int cellNumber,String loanStatus) throws SQLException{
        conn = JDBC.getConnection();
        String query = "INSERT INTO `loan` (`customernumber`, `firstname`,"
                + " `lastname`, `loanAmount`, `date`, `daysDue`, `cellNumber`,"
                + " `loanStatus`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        prst =conn.prepareStatement(query);
        prst.setInt(1, customernumber);
        prst.setString(2,firstname);
        prst.setString(3, lastname);
        prst.setDouble(4,loanAmount);
        prst.setDate(5,date);
        prst.setInt(6, daysDue);
        prst.setInt(7, cellNumber);
        prst.setString(8,loanStatus);
        prst.executeUpdate();
    }
    public static void listLoan() throws SQLException {
        conn = JDBC.getConnection();
        String query = "Select firstname, lastname, loanamount, date, daysdue, cellnumber, loanstatus FROM Loan";
        prst = conn.prepareStatement(query);
        rs = prst.executeQuery();
        while(rs.next()){
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            double loanamount = rs.getDouble("loanamount");
            Date date = rs.getDate("date");
            int daysdue = rs.getInt("daysdue");
            int cellnumber = rs.getInt("cellnumber");
            String loanstatus = rs.getString("loanstatus");

            System.out.println("First Name: " + firstname);
            System.out.println("Last Name: " + lastname);
            System.out.println("Loan Amount: " + loanamount);
            System.out.println("Date: " + date);
            System.out.println("Days Due" + daysdue);
            System.out.println("Cell: " + cellnumber);
            System.out.println("Loan Status: " + loanstatus);
        }
        rs.close();
    }

}
