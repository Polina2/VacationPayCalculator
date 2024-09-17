package ru.neoflex.edu.java.test.calculator;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.edu.java.test.calculator.service.CalculatePayService;

public class CalculatePayServiceTest {
    private final CalculatePayService calculatePayService = new CalculatePayService();
    private static final double DELTA = 1e-6;

    @Test
    public void formulaTest() {
        double avgSalary = 30000.0;
        int daysCount = 14;
        double expectedVacationPay = 14334.47099;

        double actualVacationPay = calculatePayService.calculatePay(avgSalary, daysCount);

        Assert.assertEquals(expectedVacationPay, actualVacationPay, DELTA);
    }
}
