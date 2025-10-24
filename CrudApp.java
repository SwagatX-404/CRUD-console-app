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

           
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }

    }


// CREATE : Insert Data or add user
    public static void insertUser() {

    }

// READ : view user data only
    public static void viewUsers() {

    }

// UPDATE : update user data 
    public static void updateUser() {

    }

// DELETE : delete user from DB
    public static void deleteUser() {

    }
}
