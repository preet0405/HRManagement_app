package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class SalaryDAO {
    public static double getNetSalaryForEmployee(int employeeId) {
        String sql = "SELECT basic_salary, bonus, deductions FROM salary WHERE employee_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double basic = rs.getDouble("basic_salary");
                double bonus = rs.getDouble("bonus");
                double deductions = rs.getDouble("deductions");
                return basic + bonus - deductions;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}


