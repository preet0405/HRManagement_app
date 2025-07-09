package model;

import javafx.beans.property.*;

public class Employee {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty gender;
    private StringProperty department;
    private StringProperty position;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty hireDate;

    public Employee(int id, String name, String gender, String department, String position, String email, String phone, String hireDate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.department = new SimpleStringProperty(department);
        this.position = new SimpleStringProperty(position);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.hireDate = new SimpleStringProperty(hireDate);
    }

    // Getters & Properties
    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }
    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }
    public String getGender() { return gender.get(); }
    public StringProperty genderProperty() { return gender; }
    public String getDepartment() { return department.get(); }
    public StringProperty departmentProperty() { return department; }
    public String getPosition() { return position.get(); }
    public StringProperty positionProperty() { return position; }
    public String getEmail() { return email.get(); }
    public StringProperty emailProperty() { return email; }
    public String getPhone() { return phone.get(); }
    public StringProperty phoneProperty() { return phone; }
    public String getHireDate() { return hireDate.get(); }
    public StringProperty hireDateProperty() { return hireDate; }

    // Setters
    public void setId(int id) { this.id.set(id); }
    public void setName(String name) { this.name.set(name); }
    public void setGender(String gender) { this.gender.set(gender); }
    public void setDepartment(String department) { this.department.set(department); }
    public void setPosition(String position) { this.position.set(position); }
    public void setEmail(String email) { this.email.set(email); }
    public void setPhone(String phone) { this.phone.set(phone); }
    public void setHireDate(String hireDate) { this.hireDate.set(hireDate); }
}


