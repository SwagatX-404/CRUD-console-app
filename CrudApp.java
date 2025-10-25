import java.sql.*;
import java.util.Scanner;

public class CrudApp {

    // Static Variable
    static final String URL = "jdbc:mysql://localhost:3306/demo_jdbc"; // DB-MySQL, 3306-Location, DBname-demo_jdbc
    static final String USER = "root"; // MySQL username
    static final String PASS = "swagat"; // MySQL password
    static Connection con; // A shared database link connection variable
    static Scanner sc = new Scanner(System.in); // One Scanner, Shared by All

    public static void main(String[] args) {
        try {
            //Connection to DB MYSQL through JDBC DRIVER it a connection between JavaProgram and MySQLdb 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection(URL, USER, PASS);
            
            System.out.println("SuccessFully Connected to MySQL!.......");

            //Create Menu System
            int choice; //V declare
            do {
                System.out.println("\n===== USER CRUD MENU =====");

                System.out.println("1. Insert User");
                System.out.println("2. View All Users");
                System.out.println("3. Update User Email");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                 choice = sc.nextInt();  //Variable take int type (1,2,3,4,5)
                sc.nextLine(); // consume newline

                //Handle User Choice
                switch (choice) {
                    case 1 -> insertUser();
                    case 2 -> viewUsers();
                    case 3 -> updateUser();
                    case 4 -> deleteUser();
                    case 5 -> System.out.println(" Exiting...");
                    default -> System.out.println(" Invalid choice!");
                }
            } while (choice != 5);

            con.close();
            
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }

    }


// CREATE : Insert Data or add user
    public static void insertUser() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            String q = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, email);
            int rows = ps.executeUpdate();

            if (rows > 0) 
            System.out.println(" User added!");
        } catch (SQLException e) {
            System.out.println(" Insert failed: " + e.getMessage());
        }
    }

// READ : view user data only
    public static void viewUsers() {
        try {
            String q = "SELECT * FROM users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);

            System.out.println("\n--- USER LIST ---");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-30s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(" View failed: " + e.getMessage());
        }
    }

// UPDATE : update user data 
    public static void updateUser() {
        try {
            System.out.print("Enter User ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new email: ");
            String email = sc.nextLine();

            String q = "UPDATE users SET email=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, email);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println(" User updated!");
            else System.out.println(" No user found with ID " + id);
        } catch (SQLException e) {
            System.out.println(" Update failed: " + e.getMessage());
        }
    }

// DELETE : delete user from DB
    public static void deleteUser() {
           try {
            System.out.print("Enter User ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String q = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println(" User deleted!");
            else System.out.println(" No user found with ID " + id);
        } catch (SQLException e) {
            System.out.println(" Delete failed: " + e.getMessage());
        }
    }
}
