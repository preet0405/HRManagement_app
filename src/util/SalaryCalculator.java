package util;

public class SalaryCalculator {

    /**
     * Calculate yearly salary based on monthly salary and bonus.
     * 
     * @param monthlySalary The employee's monthly salary.
     * @param annualBonus The annual bonus amount.
     * @return Yearly salary including bonus.
     */
    public static double calculateYearlySalary(double monthlySalary, double annualBonus) {
        if (monthlySalary < 0 || annualBonus < 0) {
            throw new IllegalArgumentException("Salary and bonus must be non-negative");
        }
        return (monthlySalary * 12) + annualBonus;
    }
}
