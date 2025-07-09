package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import util.SalaryCalculator;

public class SalaryCalculatorTest {

    @Test
    public void testCalculateYearlySalary_NormalCase() {
        double monthly = 3000;
        double bonus = 5000;
        double expected = (3000 * 12) + 5000;
        assertEquals(expected, SalaryCalculator.calculateYearlySalary(monthly, bonus));
    }

    @Test
    public void testCalculateYearlySalary_ZeroBonus() {
        double monthly = 4000;
        double bonus = 0;
        double expected = 4000 * 12;
        assertEquals(expected, SalaryCalculator.calculateYearlySalary(monthly, bonus));
    }

    @Test
    public void testCalculateYearlySalary_ZeroSalary() {
        double monthly = 0;
        double bonus = 1000;
        double expected = 1000;
        assertEquals(expected, SalaryCalculator.calculateYearlySalary(monthly, bonus));
    }

    @Test
    public void testCalculateYearlySalary_NegativeSalary() {
        assertThrows(IllegalArgumentException.class, () -> {
            SalaryCalculator.calculateYearlySalary(-1000, 1000);
        });
    }

    @Test
    public void testCalculateYearlySalary_NegativeBonus() {
        assertThrows(IllegalArgumentException.class, () -> {
            SalaryCalculator.calculateYearlySalary(1000, -500);
        });
    }
}

