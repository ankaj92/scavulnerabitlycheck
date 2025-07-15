import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // SQL Injection Vulnerability
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            // Vulnerable SQL query (no parameterized query)
            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cross-Site Scripting (XSS) Vulnerability
        String userInput = "<script>alert('XSS');</script>";
        System.out.println("User input: " + userInput);

        // Hardcoded Secret
        String apiKey = "12345-SECRET-API-KEY";
        System.out.println("API Key: " + apiKey);
    }
}