## This program is meant to perform basic operations on a database, which are often called CRUD operations:

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

***Open Project PATH and then open cmd***
**First Compile and then Run**

```bash
    javac -cp .;mysql-connector-j-9.5.0.jar CrudApp.java

    java -cp .;mysql-connector-j-9.5.0.jar CrudApp
```
## Snapshots
<img width="1264" height="851" alt="Screenshot 2025-10-25 223553" src="https://github.com/user-attachments/assets/4098b0e9-fcf8-49ba-9d58-11ee3de74669" />
<img width="1283" height="974" alt="Screenshot 2025-10-25 223440" src="https://github.com/user-attachments/assets/07e25b7f-d1ce-433f-b1dd-271f9d3a1bad" />
<img width="945" height="1017" alt="Screenshot 2025-10-23 231246" src="https://github.com/user-attachments/assets/aab9f672-6fd6-470f-8766-6dbadb554b3b" />

