package controller;

import dao.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    private TextField emailField;       // Use emailField for admin login

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (LoginDAO.validate(email, password)) {
            try {
                // Load Dashboard
                Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
                Stage stage = (Stage) emailField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Dashboard");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText("Failed to load dashboard!");
            }
        } else {
            messageLabel.setText("Invalid username or password!");
        }
    }
}

