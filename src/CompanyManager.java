
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grc29
 */
public class CompanyManager {
     public static void managerLogin(Company company) {
        // Simulate manager login
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please log in as the manager.");
        System.out.print("Username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Password: ");
        String passwordInput = scanner.nextLine();
        
        if (usernameInput.equals(company.getUsername()) && passwordInput.equals(company.getPassword())) {
            // Successful login
            System.out.println("Login successful!");
            // Display menu options
            System.out.println("Menu:");
            System.out.println("1. View current staff");
            System.out.println("2. Add new staff");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if (choice == 1) {
                // View current staff
                System.out.println("Current staff:");
                for (Employee employee : company.getStaff()) {
                    System.out.println(employee.getName());
                }
            } else if (choice == 2) {
                // Add new staff
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter employee email: ");
                String email = scanner.nextLine();
                Employee newEmployee = new Employee(name, email);
                company.addNewStaff(newEmployee);
                System.out.println("New employee added successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            // Failed login
            System.out.println("Invalid username or password. Access denied.");
        }
        
        // Close scanner
        scanner.close();
    }
}