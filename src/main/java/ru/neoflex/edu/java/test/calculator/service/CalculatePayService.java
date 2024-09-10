package ru.neoflex.edu.java.test.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatePayService {
    private static final double DAYS_IN_MONTH = 29.3;

    public Double calculatePay(Double avgSalary, Integer daysCount) {
        return avgSalary / DAYS_IN_MONTH * daysCount;
    }
}
