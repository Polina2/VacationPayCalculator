package ru.neoflex.edu.java.test.calculator.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class CalculateResponse {
    @NonNull Double vacationPay;
}
