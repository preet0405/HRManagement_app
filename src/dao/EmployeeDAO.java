package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeDetail";

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
                employees.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO EmployeeDetail (name, gender, department, position, email, phone, hire_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getGender());
            pstmt.setString(3, emp.getDepartment());
            pstmt.setString(4, emp.getPosition());
            pstmt.setString(5, emp.getEmail());
            pstmt.setString(6, emp.getPhone());
            pstmt.setString(7, emp.getHireDate());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE EmployeeDetail SET name=?, gender=?, department=?, position=?, email=?, phone=?, hire_date=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getGender());
            pstmt.setString(3, emp.getDepartment());
            pstmt.setString(4, emp.getPosition());
            pstmt.setString(5, emp.getEmail());
            pstmt.setString(6, emp.getPhone());
            pstmt.setString(7, emp.getHireDate());
            pstmt.setInt(8, emp.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EmployeeDetail WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


