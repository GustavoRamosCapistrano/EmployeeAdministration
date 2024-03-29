/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Git: https://github.com/GustavoRamosCapistrano/EmployeeAdministration
/**
 *
 * @author grc29
 */
// Class to test funcionallity of the program
public class EmployeeTest {
    public static void main(String[] args) {
        // Creating Employee objects and adding them to an array
        Employee emp1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee emp2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee emp3 = new Employee("Tom Thumb", "tt@gmail.com");
        Employee emp4 = new Employee("Gnomeo Smurf", "gs@gmail.com");

        Employee[] projectGroup = {emp1, emp2, emp3, emp4};
        // Printing next employee number
        System.out.println("Next Employee Number: " + Employee.getNextEmpNum());
        
        // Searching and displaying names of employees with empNum above m
        int m = 2;
        System.out.println("Employees with empNum above " + m + ":");
        for (Employee employee : projectGroup) {
            if (employee.getEmpNum() > m) {
                System.out.println(employee.getName());
            }
        }

        // Creating Company object and adding employees
        Company company = new Company("Business Gnómes Ltd");
        company.setUsername("Gnomeo");
        company.setPassword("smurf");

        for (Employee employee : projectGroup) {
            company.addNewStaff(employee);
        }
        // Logging in as manager and accessing menu
        CompanyManager.managerLogin(company);
    }
}
