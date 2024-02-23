
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        setEmail(email); // Use setEmail method for validation
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

   public void setEmail(String email) {
        // Regular expression pattern for validating email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        if (matcher.matches()) {
            this.email = email;
        } else {
            System.out.println("Invalid email address format.");
        }
    }

    // Method to get nextEmpNum
    public static int getNextEmpNum() {
        return nextEmpNum;
    }

}
