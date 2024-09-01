package ru.neoflex.edu.java.test.calculator.dto;

import lombok.*;

import java.util.Date;

@Value
public class CalculateRequest {
    @NonNull Double avgSalary;
    @NonNull Integer daysCount;
    Date startDate;
    Date endDate;
}
