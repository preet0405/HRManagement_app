package dao;

import model.Employee;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("department"),
                    rs.getString("position"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("hire_date")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee (name, gender, department, position, email, phone, hire_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getGender());
            stmt.setString(3, emp.getDepartment());
            stmt.setString(4, emp.getPosition());
            stmt.setString(5, emp.getEmail());
            stmt.setString(6, emp.getPhone());
            stmt.setString(7, emp.getHireDate());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET name=?, gender=?, department=?, position=?, email=?, phone=?, hire_date=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getGender());
            stmt.setString(3, emp.getDepartment());
            stmt.setString(4, emp.getPosition());
            stmt.setString(5, emp.getEmail());
            stmt.setString(6, emp.getPhone());
            stmt.setString(7, emp.getHireDate());
            stmt.setInt(8, emp.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


