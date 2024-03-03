
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author grc29
 */
//Class to manage the longin process and menu for this company
public class CompanyManager {
    
    // Method to handle manager login and menu access
    public static void managerLogin(Company company) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        
        // Manager login process
        while (!loggedIn) {
            System.out.println("Please log in as the manager.");
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine();
            if (usernameInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }
            System.out.print("Password: ");
            String passwordInput = scanner.nextLine();
            if (passwordInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }

            // Check username and password
            if (usernameInput.equals(company.getUsername()) && passwordInput.equals(company.getPassword())) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Access denied.");
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
            // Validate user input
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.println("Menu:");
                    System.out.println("1. View current staff");
                    System.out.println("2. Add new staff");
                    System.out.println("3. Remove staff");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    scanner.next();
                }
            }
            
            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("Viewing current staff...");
                    company.listEmployees(0);
                    break;
                case 2:
                    System.out.println("Adding new staff...");
                    System.out.print("Enter employee name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    String email;
                    boolean validEmailFormat;

                    do {
                        System.out.print("Enter employee email: ");
                        email = scanner.nextLine();
                        validEmailFormat = Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", email);
                        if (!validEmailFormat) {
                            System.out.println("Invalid email address format. Please try again.");
                        }
                    } while (!validEmailFormat);

                    Employee newEmployee = new Employee(name, email);
                    company.addNewStaff(newEmployee);
                    System.out.println("New employee added successfully.");
                    break;
                case 3:
                    System.out.print("Enter employee empNum to remove: ");
                    int empNumToRemove = scanner.nextInt();
                    scanner.nextLine();
                    company.removeStaff(empNumToRemove);
                    break;
                case 4:
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
