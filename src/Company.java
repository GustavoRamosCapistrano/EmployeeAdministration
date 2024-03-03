
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author grc29
 */
//Class to create the company
public class Company {
    private String companyName;
    private ArrayList<Employee> staff;
    private String username;
    private String password;
    private HashSet<Integer> staffSet;
    
    //contructors 
    
    //Defaur contructor and create a empty staff list.
    public Company() {
        this.companyName = "Default Company";
        this.staff = new ArrayList<>();
        this.staffSet = new HashSet<>();
    }

    //Constructor initializes company name and creates an empty staff list.
    public Company(String companyName) {
        this.companyName = companyName;
        this.staff = new ArrayList<>();
        this.staffSet = new HashSet<>();
    }
     // Method to add a new employee to the company's staff list
    public void addNewStaff(Employee employee) {
        staff.add(employee);
        staffSet.add(employee.getEmpNum());
    }

    // Method to remove an employee from the company's staff list
    public void removeStaff(int empNum) {
        Iterator<Employee> iterator = staff.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() == empNum) {
                iterator.remove();
                staffSet.remove(empNum);
                System.out.println("Employee with empNum " + empNum + " removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee with empNum " + empNum + " does not exist.");
        }
    }
    
    // Method to get the number of employees in the company
    public int getStaffNumber() {
        return staff.size();
    }
    
    // Method to list employees with empNum above a certain threshold
    public void listEmployees(int empNumThreshold) {
        System.out.println("Employees with empNum above " + empNumThreshold + ":");
        for (Employee employee : staff) {
            if (employee.getEmpNum() > empNumThreshold) {
                System.out.println("Name: " + employee.getName());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("EmpNumber: " + employee.getEmpNum());
                System.out.println();
            }
        }
    }
    
    // Method to check if an employee with a given empNum exists
    public boolean employeeExists(int empNum) {
        return staffSet.contains(empNum);
    }

    // Getter and setter methods for username and password
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }
}

