package ru.neoflex.edu.java.test.calculator.dto;

import lombok.Value;

import java.util.List;

@Value
public class ApiErrorResponse {
    Integer statusCode;
    String exceptionName;
    String exceptionMessage;
    List<String> stacktrace;
}
