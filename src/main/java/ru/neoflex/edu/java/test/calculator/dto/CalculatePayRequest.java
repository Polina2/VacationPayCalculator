package ru.neoflex.edu.java.test.calculator.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Value
public class CalculatePayRequest {
    @NotNull @Positive Double avgSalary;
    @Positive Integer daysCount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endDate;
}
