package ru.neoflex.edu.java.test.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatePayService {
    public Double calculatePay(Double avgSalary, Integer daysCount) {
        return avgSalary / 29.3 * daysCount;
    }
}
