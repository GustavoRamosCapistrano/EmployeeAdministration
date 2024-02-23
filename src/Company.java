
import java.util.ArrayList;
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

    public Company() {
        this.companyName = "Default Company";
        this.staff = new ArrayList<>();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.staff = new ArrayList<>();
    }

    public void addNewStaff(Employee employee) {
        staff.add(employee);
    }

    public int getStaffNumber() {
        return staff.size();
    }

    public void listEmployees(int empNumThreshold) {
        Iterator<Employee> iterator = staff.iterator();
        System.out.println("Employees with empNum above " + empNumThreshold + ":");
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() > empNumThreshold) {
                System.out.println(employee.getName());
            }
        }
    }
    private String username;
    private String password;

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
}
