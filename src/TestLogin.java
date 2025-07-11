import dao.LoginDAO;

public class TestLogin {
    public static void main(String[] args) {
        System.out.println(LoginDAO.validate("alice.johnson@hr.com", "admin123"));  // should print true
        System.out.println(LoginDAO.validate("bob.smith@hr.com", "bobpass456"));    // should print true
        System.out.println(LoginDAO.validate("clara.james@hr.com", "clara789"));    // should print true
        System.out.println(LoginDAO.validate("alice.johnson@hr.com", "wrongpass")); // should print false
    }
}

