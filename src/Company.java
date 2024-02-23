
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
public class Company {

    private String companyName;
    private ArrayList<Employee> staff;
    private String username;
    private String password;
    private HashSet<Integer> staffSet;

    public Company() {
        this.companyName = "Default Company";
        this.staff = new ArrayList<>();
        this.staffSet = new HashSet<>();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.staff = new ArrayList<>();
        this.staffSet = new HashSet<>();
    }

    public void addNewStaff(Employee employee) {
        staff.add(employee);
    }

    public void removeStaff(int empNum) {
        Iterator<Employee> iterator = staff.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() == empNum) {
                iterator.remove();
                staffSet.remove(empNum); // Remove from HashSet as well
                System.out.println("Employee with empNum " + empNum + " removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee with empNum " + empNum + " does not exist.");
        }
    }

    public int getStaffNumber() {
        return staff.size();
    }

    public void listEmployees(int empNumThreshold) {
        System.out.println("Employees with empNum above " + empNumThreshold + ":");
        for (Employee employee : staff) {
            if (employee.getEmpNum() > empNumThreshold) {
                System.out.println("Name: " + employee.getName());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("EmpNumber: " + employee.getEmpNum());
                System.out.println(); // Add a newline for separation
            }
        }
    }

    public boolean employeeExists(int empNum) {
        return staffSet.contains(empNum);
    }

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
