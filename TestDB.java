import java.sql.*;

public class TestDB {
    public static void main(String[] args) throws Exception {
        // Update with your own database URL, user, pass
        String url = "jdbc:mysql://localhost:3306/hr_management";
        String user = "root"; // or whatever your MySQL user is
        String pass = ""; // or your password

        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
        while (rs.next()) {
            System.out.println(
                rs.getString("email") + " : " + rs.getString("password")
            );
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
