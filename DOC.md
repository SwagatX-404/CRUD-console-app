This program is meant to perform basic operations on a database, which are often called CRUD operations:
  
    Create (Add new data)
    Read (View data)
    Update (Edit data)
    Delete (Remove data)

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