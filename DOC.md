**This program is meant to perform basic operations on a database, which are often called CRUD operations:**
- Create (Add new data)
- Read (View data)
- Update (Edit data)
- Delete (Remove data)

# STEP - 1

    Import Tools:
```java  
    import java.sql.*;
    import java.util.Scanner;
```
sql.* for talk to database 
utile.Scanner  for get input 

***Declare Satic Variable***
```java
static final String URL = "jdbc:mysql://localhost:3306/demo_jdbc";
static final String USER = "root";
static final String PASS = "swagat";
static Connection con;     //specialType V: Stores a DATABASE CONNECTION
static Scanner sc = new Scanner(System.in);
```
Static: means Always-Available to anyone in the class methode()
Finale: means can not be changed variable value
URL: Address of the database it is a "String" type.
        jdbc:mysql:// : The type of database (MySQL).
    localhost:3306 : The location (our own computer) and the "door number" (port 3306).
    /demo_jdbc : The name of the specific database to use.

static Connection con;
It is a special type of variable. static-shared by , connection-Live link to DB, con-variable
import java.sql.*;  // ← This import brings in the Connection class
Connection Variable (Reference Type):
Connection con = DriverManager.getConnection(URL, USER, PASS);
Make it Special -> Instead of holding simple values like 10 or "hello", it holds a **complex object**that represents an active connection to your database

# STEP - 1

Setup Database Connection
```java

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(URL, USER, PASS);
    System.out.println("✅ Connected to MySQL!");
    
```
    Loads MySQL driver (tells Java how to talk to MySQL)
    Establishes connection using your URL, username, and password
    Shows success message when connected

**Create Menu System**
```java

int choice;
do {
    System.out.println("\n===== USER CRUD MENU =====");
    System.out.println("1. Insert User");
    System.out.println("2. View All Users");
    System.out.println("3. Update User Email");
    System.out.println("4. Delete User");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
    choice = sc.nextInt();
    sc.nextLine(); // consume newline
    
```
    Displays menu options (1-5)
    Gets user's choice from keyboard
    Clears input buffer (to avoid skipping inputs)

**Handle User Choice**
```java

switch (choice) {
    case 1 -> insertUser();
    case 2 -> viewUsers();
    case 3 -> updateUser();
    case 4 -> deleteUser();
    case 5 -> System.out.println(" Exiting...");
    default -> System.out.println("Invalid choice!");
}
```
    Calls appropriate method based on user's choice
    1-4 call CRUD operations
    5 exits the program
    Any other number shows error

   **Loop Until Exit**
```java
} while (choice != 5);
```
    Keeps showing menu until user chooses 5 (Exit)
    Creates a continuous loop for multiple operations

**Cleanup & Error Handling**
```java
con.close();
} catch (Exception e) {
    System.out.println("❌ Error: " + e.getMessage());
}
```
Closes database connection when done
Catches any errors that occur and shows messag

***Simple Flow:***
    Connect to database
    Show menu repeatedly
    Execute chosen operation
    Repeat until user exits
    Close connection and handle errors

    