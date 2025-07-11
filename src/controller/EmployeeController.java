package controller;

import dao.EmployeeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Employee;

public class EmployeeController {

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> idCol;
    @FXML
    private TableColumn<Employee, String> nameCol;
    @FXML
    private TableColumn<Employee, String> genderCol;
    @FXML
    private TableColumn<Employee, String> departmentCol;
    @FXML
    private TableColumn<Employee, String> positionCol;
    @FXML
    private TableColumn<Employee, String> emailCol;
    @FXML
    private TableColumn<Employee, String> phoneCol;
    @FXML
    private TableColumn<Employee, String> hireDateCol;

    @FXML
    private TextField nameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField hireDateField;

    @FXML
    private Label netSalaryLabel;
    @FXML
    private Label messageLabel;

    private ObservableList<Employee> employeeList;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        genderCol.setCellValueFactory(data -> data.getValue().genderProperty());
        departmentCol.setCellValueFactory(data -> data.getValue().departmentProperty());
        positionCol.setCellValueFactory(data -> data.getValue().positionProperty());
        emailCol.setCellValueFactory(data -> data.getValue().emailProperty());
        phoneCol.setCellValueFactory(data -> data.getValue().phoneProperty());
        hireDateCol.setCellValueFactory(data -> data.getValue().hireDateProperty());

        employeeList = FXCollections.observableArrayList(dao.EmployeeDAO.getAllEmployees());
        employeeTable.setItems(employeeList);

        employeeTable.setOnMouseClicked(event -> {
            Employee selected = employeeTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                nameField.setText(selected.getName());
                genderField.setText(selected.getGender());
                departmentField.setText(selected.getDepartment());
                positionField.setText(selected.getPosition());
                emailField.setText(selected.getEmail());
                phoneField.setText(selected.getPhone());
                hireDateField.setText(selected.getHireDate());

                // Show net salary
                double netSalary = dao.SalaryDAO.getNetSalaryForEmployee(selected.getId());
                netSalaryLabel.setText("Net Salary: $" + String.format("%.2f", netSalary));
            } else {
                netSalaryLabel.setText("");
            }
        });
    }

    @FXML
    private void handleAdd() {
        String name = nameField.getText();
        String gender = genderField.getText();
        String department = departmentField.getText();
        String position = positionField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String hireDate = hireDateField.getText();

        if (name.isEmpty() || gender.isEmpty() || department.isEmpty() || position.isEmpty() ||
            email.isEmpty() || phone.isEmpty() || hireDate.isEmpty()) {
            messageLabel.setText("All fields are required.");
            return;
        }

        Employee newEmployee = new Employee(0, name, gender, department, position, email, phone, hireDate);
        boolean success = EmployeeDAO.insertEmployee(newEmployee);

        if (success) {
            messageLabel.setText("Employee added successfully.");
            employeeList.setAll(EmployeeDAO.getAllEmployees());
            clearFields();
        } else {
            messageLabel.setText("Error adding employee.");
        }
    }

    @FXML
    private void handleUpdate() {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Please select an employee to update.");
            return;
        }
        selected.setName(nameField.getText());
        selected.setGender(genderField.getText());
        selected.setDepartment(departmentField.getText());
        selected.setPosition(positionField.getText());
        selected.setEmail(emailField.getText());
        selected.setPhone(phoneField.getText());
        selected.setHireDate(hireDateField.getText());

        boolean success = EmployeeDAO.updateEmployee(selected);
        if (success) {
            messageLabel.setText("Employee updated successfully.");
            employeeList.setAll(EmployeeDAO.getAllEmployees());
            clearFields();
        } else {
            messageLabel.setText("Error updating employee.");
        }
    }

    @FXML
    private void handleDelete() {
        Employee selected = employeeTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Please select an employee to delete.");
            return;
        }
        boolean success = EmployeeDAO.deleteEmployee(selected.getId());
        if (success) {
            messageLabel.setText("Employee deleted successfully.");
            employeeList.setAll(EmployeeDAO.getAllEmployees());
            clearFields();
        } else {
            messageLabel.setText("Error deleting employee.");
        }
    }

    private void clearFields() {
        nameField.clear();
        genderField.clear();
        departmentField.clear();
        positionField.clear();
        emailField.clear();
        phoneField.clear();
        hireDateField.clear();
    }
}

