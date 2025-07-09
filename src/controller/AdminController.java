package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminController {

    @FXML
    private TableView<?> adminTable;

    @FXML
    private TextField nameField, emailField, passwordField;

    @FXML
    private void addAdmin() {
        // Your code to add admin
    }

    @FXML
    private void updateAdmin() {
        // Your code to update admin
    }

    @FXML
    private void deleteAdmin() {
        // Your code to delete admin
    }

    // If you want a back button to return to dashboard or login, implement here
    // For example:
    /*
    @FXML
    private void backToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    */
}


