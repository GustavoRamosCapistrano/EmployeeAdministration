/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grc29
 */
public class EmployeeTest {
    public static void main(String[] args) {
        // Create 3 Employee objects
        Employee emp1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee emp2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee emp3 = new Employee("Tom Thumb", "tt@gmail.com");

        // Declare and load array with Employee objects
        Employee[] projectGroup = {emp1, emp2, emp3};

        // Print out the value of nextEmpNum
        System.out.println("Next Employee Number: " + Employee.getNextEmpNum());

        // Search and display the name of employees with empNum above m
        int m = 2; // Example value for m
        System.out.println("Employees with empNum above " + m + ":");
        for (Employee employee : projectGroup) {
            if (employee.getEmpNum() > m) {
                System.out.println(employee.getName());
            }
        }
    }
}
