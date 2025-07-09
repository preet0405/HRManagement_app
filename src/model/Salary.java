package model;

public class Salary {
    private double monthlySalary;

    public Salary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double calculateYearlySalary() {
        return monthlySalary * 12;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
}
