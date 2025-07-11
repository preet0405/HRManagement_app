package controller;

import dao.AdminDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;

public class AdminController {

    @FXML private TableView<Admin> adminTable;
    @FXML private TableColumn<Admin, Integer> idCol;
    @FXML private TableColumn<Admin, String> nameCol;
    @FXML private TableColumn<Admin, String> emailCol;
    @FXML private TableColumn<Admin, String> passwordCol;

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField passwordField;

    private ObservableList<Admin> adminList;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        emailCol.setCellValueFactory(data -> data.getValue().emailProperty());
        passwordCol.setCellValueFactory(data -> data.getValue().passwordProperty());

        adminList = FXCollections.observableArrayList(AdminDAO.getAllAdmins());
        adminTable.setItems(adminList);

        adminTable.setOnMouseClicked(event -> {
            Admin selected = adminTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                nameField.setText(selected.getName());
                emailField.setText(selected.getEmail());
                passwordField.setText(selected.getPassword());
            }
        });
    }

    @FXML
    private void handleAdd() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("All fields are required.");
            return;
        }

        Admin newAdmin = new Admin(0, name, email, password);
        boolean success = AdminDAO.insertAdmin(newAdmin);

        if (success) {
            showAlert("Admin added successfully.");
            adminList.setAll(AdminDAO.getAllAdmins());
            clearFields();
        } else {
            showAlert("Error adding admin.");
        }
    }

    @FXML
    private void handleUpdate() {
        Admin selected = adminTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select an admin to update.");
            return;
        }

        selected.setName(nameField.getText());
        selected.setEmail(emailField.getText());
        selected.setPassword(passwordField.getText());

        boolean success = AdminDAO.updateAdmin(selected);

        if (success) {
            showAlert("Admin updated successfully.");
            adminList.setAll(AdminDAO.getAllAdmins());
            clearFields();
        } else {
            showAlert("Error updating admin.");
        }
    }

    @FXML
    private void handleDelete() {
        Admin selected = adminTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select an admin to delete.");
            return;
        }

        boolean success = AdminDAO.deleteAdmin(selected.getId());

        if (success) {
            showAlert("Admin deleted successfully.");
            adminList.setAll(AdminDAO.getAllAdmins());
            clearFields();
        } else {
            showAlert("Error deleting admin.");
        }
    }

    private void clearFields() {
        nameField.clear();
        emailField.clear();
        passwordField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }
}



