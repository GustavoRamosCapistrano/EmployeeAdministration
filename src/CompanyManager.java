
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
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Please log in as the manager.");
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine();
            System.out.print("Password: ");
            String passwordInput = scanner.nextLine();

            if (usernameInput.equals(company.getUsername()) && passwordInput.equals(company.getPassword())) {
                // Successful login
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                // Failed login
                System.out.println("Invalid username or password. Access denied.");
                System.out.println("Please try again or type 'exit' to quit.");
                String exitInput = scanner.nextLine();
                if (exitInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }

        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. View current staff");
            System.out.println("2. Add new staff");
            System.out.println("3. Remove staff");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    company.listEmployees(1);
                    break;
                case 2:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee email: ");
                    String email = scanner.nextLine();
                    Employee newEmployee = new Employee(name, email);
                    company.addNewStaff(newEmployee);
                    System.out.println("New employee added successfully.");
                    break;
                case 3:
                    System.out.print("Enter employee empNum to remove: ");
                    int empNumToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    company.removeStaff(empNumToRemove);
                    break;
                case 4:
                    // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        // Close scanner
        scanner.close();
    }
}
