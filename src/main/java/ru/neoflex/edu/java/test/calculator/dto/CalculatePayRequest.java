package ru.neoflex.edu.java.test.calculator.dto;

import lombok.*;

import java.time.LocalDate;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CalculatePayRequest {
    @NonNull Double avgSalary;
    @NonNull Integer daysCount;
    LocalDate startDate;
    LocalDate endDate;
}
