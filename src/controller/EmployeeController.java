package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class EmployeeController {

    @FXML
    private TableView<?> employeeTable;

    @FXML
    private TextField nameField, genderField, deptField, posField,
                      emailField, phoneField, hireDateField;

    // New fields for salary calculation
    @FXML
    private TextField baseSalaryField, bonusField, taxField;

    @FXML
    private Label salaryResultLabel;

    // Example Add, Update, Delete methods — fill with your logic
    @FXML
    private void addEmployee() {
        // Your code to add employee
    }

    @FXML
    private void updateEmployee() {
        // Your code to update employee
    }

    @FXML
    private void deleteEmployee() {
        // Your code to delete employee
    }

    // Salary calculation method
    public double calculateSalary(double baseSalary, double bonus, double taxPercent) {
        double gross = baseSalary + bonus;
        double tax = gross * (taxPercent / 100.0);
        return gross - tax;
    }

    // Button handler to calculate salary
    @FXML
    private void calculateSalaryButtonClicked(ActionEvent event) {
        try {
            double baseSalary = Double.parseDouble(baseSalaryField.getText());
            double bonus = Double.parseDouble(bonusField.getText());
            double taxPercent = Double.parseDouble(taxField.getText());

            double netSalary = calculateSalary(baseSalary, bonus, taxPercent);
            salaryResultLabel.setText(String.format("Net Salary: $%.2f", netSalary));
        } catch (NumberFormatException e) {
            salaryResultLabel.setText("Please enter valid numbers!");
        }
    }
}



