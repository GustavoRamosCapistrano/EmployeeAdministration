
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
public class CompanyManager {

    public static void managerLogin(Company company) {
        // Simulate manager login
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

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

            if (usernameInput.equals(company.getUsername()) && passwordInput.equals(company.getPassword())) {
                // Successful login
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                // Failed login
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
                    scanner.next(); // Consume invalid input
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Viewing current staff...");
                    company.listEmployees(0);
                    break;
                case 2:
                    // Add new staff
                    System.out.println("Adding new staff...");

                    // Prompt for employee name
                    System.out.print("Enter employee name: ");
                    scanner.nextLine(); // Consume newline character
                    String name = scanner.nextLine();

                    // Prompt for employee email
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
