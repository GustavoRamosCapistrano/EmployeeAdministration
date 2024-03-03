
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grc29
 */

// class with the employee (name, email and employee number).
public class Employee {
    //fields for the class
    private String name;
    private String email;
    private int empNum;
    private static int nextEmpNum = 1;

    //Default constructor
    public Employee() {
        this.name = "Default";
        this.email = "default@email.com";
        this.empNum = nextEmpNum++;
    }
    // Contructor with name and email provided and check for valid email and give unique empNum
    public Employee(String name, String email) {
        this.name = name;
        setEmail(email);
        this.empNum = nextEmpNum++;
    }
    //Getter methods
    // Gets name of the employee
    public String getName() {
        return name;
    }
    
    // Gets the email address of the employee.
    public String getEmail() {
        return email;
    }
    //Gets the employee number of the employee.
    public int getEmpNum() {
        return empNum;
    }
    // Static method to get the next employee number
    public static int getNextEmpNum() {
        return nextEmpNum;
    }
    // Setter method for email with validation fallowing regex protocols
    public void setEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
        } else {
            System.out.println("Invalid email address format.");
        }
    }
}