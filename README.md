his program is meant to perform basic operations on a database, which are often called CRUD operations:

    Create (Add new data)
    Read (View data)
    Update (Edit data)
    Delete (Remove data)

## 1.Database Setup

Create the database and table in MySQL Workbench  :

```sql
CREATE DATABASE demo_jdbc;
USE demo_jdbc;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 2. Configuration
```java 
String url = "jdbc:mysql://localhost:3306/demo_jdbc";
String username = "your_mysql_username";
String password = "your_mysql_password";
```


**First Compile and then Run**

```bash
    javac -cp .;mysql-connector-j-9.5.0.jar CrudApp.java

    java -cp .;mysql-connector-j-9.5.0.jar CrudApp
```