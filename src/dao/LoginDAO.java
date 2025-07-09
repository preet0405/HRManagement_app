package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    // Checks if a user with the given email and password exists in the Admin table
    public static boolean validate(String email, String password) {
        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if a row was found

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


