HR Management System

I have taken help from the class collaboration as well as chatgpt, w3schools and copilot in crud functions and fxml files.

🚀 Project Overview
The HR Management System is a sleek desktop application built with JavaFX designed to streamline the management of employee and admin records. This intuitive system offers separate dashboards for Admin and Employee management, enabling CRUD operations with smooth navigation and a user-friendly interface.

🔥 Key Features
Admin Dashboard

View, add, update, and delete admin profiles

Manage user credentials securely (passwords stored temporarily for demo)

Clean and responsive UI with data tables

Employee Dashboard

Display comprehensive employee data with customizable columns

Manage employee info including name, gender, department, position, contact details, and hire date

Seamless data entry and modification through form controls

Navigation

Easy switching between Admin and Employee modules via Dashboard buttons

Consistent layout and styling for a professional look

🛠 Technology Stack
Technology	Version/Details
Java	17+
JavaFX	8+
FXML	UI markup and layout
MVC Pattern	For clean code separation
CSS	Styling and theming

📁 Project Structure
pgsql
Copy
Edit
├── src
│   ├── controller
│   │   ├── AdminController.java
│   │   ├── EmployeeController.java
│   │   └── DashboardController.java
│   ├── model
│   │   ├── Admin.java
│   │   └── Employee.java
│   └── view
│       ├── admin.fxml
│       ├── employee.fxml
│       └── dashboard.fxml
├── style
│   └── style.css
├── MainApp.java
└── README.md
🎯 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/hr-management-javafx.git
cd hr-management-javafx
Configure JavaFX:

Download and setup JavaFX SDK (version 8 or above).

Add JavaFX libraries to your IDE or compile/run commands.

Compile & Run:

Using IDE: Run MainApp.java as a Java application.

Using command line:

bash
Copy
Edit
javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -d out src/**/*.java
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp out MainApp
Use the app:

Start on the Dashboard.

Click Admin or Employee buttons to manage data.

Add, update, delete records as needed.

💡 Future Improvements
Integration with a database (MySQL, SQLite) for persistent storage.

Enhanced validation and error handling.

Password hashing for security.

User authentication and role-based access control.

Export/import functionality (CSV, Excel).

Responsive UI enhancements.

🎨 Styling
The project includes a style.css file for consistent theme:

css
Copy
Edit
.label-title {
    -fx-font-size: 24px;
    -fx-font-weight: bold;
    -fx-padding: 10px;
}

.button {
    -fx-background-color: #4CAF50;
    -fx-text-fill: white;
    -fx-font-weight: bold;
}

👨‍💻 Author
Preet Patel

