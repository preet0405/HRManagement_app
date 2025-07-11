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

    // Getters
    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public String getGender() { return gender.get(); }
    public String getDepartment() { return department.get(); }
    public String getPosition() { return position.get(); }
    public String getEmail() { return email.get(); }
    public String getPhone() { return phone.get(); }
    public String getHireDate() { return hireDate.get(); }

    // Setters
    public void setName(String value) { name.set(value); }
    public void setGender(String value) { gender.set(value); }
    public void setDepartment(String value) { department.set(value); }
    public void setPosition(String value) { position.set(value); }
    public void setEmail(String value) { email.set(value); }
    public void setPhone(String value) { phone.set(value); }
    public void setHireDate(String value) { hireDate.set(value); }

    // Properties
    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty genderProperty() { return gender; }
    public StringProperty departmentProperty() { return department; }
    public StringProperty positionProperty() { return position; }
    public StringProperty emailProperty() { return email; }
    public StringProperty phoneProperty() { return phone; }
    public StringProperty hireDateProperty() { return hireDate; }
}




