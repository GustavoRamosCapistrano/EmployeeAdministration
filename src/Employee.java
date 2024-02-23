/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grc29
 */
public class Employee {

    private String name;
    private String email;
    private int empNum;

    private static int nextEmpNum = 1;

    public Employee() {
        this.name = "Default";
        this.email = "default@email.com";
        this.empNum = nextEmpNum++;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.empNum = nextEmpNum++;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmpNum() {
        return empNum;
    }

    // Method to set email with validation
    public void setEmail(String email) {
        if (email.length() > 3) {
            this.email = email;
        } else {
            System.out.println("Email must be longer than 3 characters.");
        }
    }

    // Method to get nextEmpNum
    public static int getNextEmpNum() {
        return nextEmpNum;
    }

}
