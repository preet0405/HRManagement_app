# 🏢 HRManagement_PreetPatel

I have taken help from the class collaboration as well as chatgpt, w3schools and copilot in crud functions and fxml files.

A **JavaFX Desktop Application** for efficient **Employee & Admin Management** with integrated **Salary Calculation** and **MySQL** database connectivity.

---

## 🚀 Project Overview

This project is a robust Human Resource Management System developed in JavaFX. It allows Admins to manage employee records seamlessly, while employees can view their profiles including dynamically calculated **Net Salary** based on stored salary components.

---

## ✨ Features

- 🔐 Secure Login for Admin and Employees  
- 👥 Full CRUD operations for Employee and Admin records  
- 💰 Salary Calculation:  
  **Net Salary = Basic Salary + Bonus - Deductions**  
- 🖥️ Intuitive and Responsive JavaFX User Interface  
- 🔗 MySQL Database integration via JDBC  
- 📁 Organized project structure following MVC pattern  

---

## 🏗️ Project Structure

src/
├── app/ # Application entry point (MainApp.java)
├── controller/ # JavaFX controllers handling UI logic
├── dao/ # Data Access Objects for database operations
├── model/ # Entity models (Employee, Admin, Salary)
├── util/ # Utility classes (DB Connection, Salary Calculation)
├── view/ # FXML UI layouts
out/ # Compiled class files (excluded from repo)
lib/ # External dependencies (MySQL Connector)

yaml
Copy

---

## 💻 Prerequisites

- Java 17 or higher  
- JavaFX SDK 24.0.1  
- MySQL Server (configured with proper tables)  
- MySQL Connector/J 9.3.0 (JDBC driver)  

---

## 🛠️ Setup & Installation

1. **Clone the Repository**

```bash
git clone https://github.com/yourusername/HRManagement_PreetPatel.git
cd HRManagement_PreetPatel
Configure MySQL

Create required databases and tables (Employee, Admin, Salary) as per your schema.

Update database credentials in src/util/DBConnection.java:

java
Copy
private static final String URL = "jdbc:mysql://localhost:3306/your_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
Compile the Project

bash
Copy
javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp ".;lib/mysql-connector-j-9.3.0.jar" -d out @sources.txt
Run the Application

bash
Copy
java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp "out;lib/mysql-connector-j-9.3.0.jar" app.MainApp
🎯 Usage Guide
Launch the app and login using Admin or Employee credentials.

Navigate through dashboards for managing or viewing data.

Employee net salary is automatically computed and displayed by the app:

java
Copy
Net Salary = Basic Salary + Bonus - Deductions
Add, update, or delete records and changes will reflect in the database immediately.

📌 Important Notes
Ensure MySQL server is running before launching the app.

Double-check database connection parameters in DBConnection.java.

The project follows MVC design for maintainability and scalability.

📝 License
This project is licensed under the MIT License. Feel free to modify and use it.

🙋‍♂️ Author
Preet Patel

⭐️ Support
If you find this project useful, please ⭐️ star the repo and share your feedback!
