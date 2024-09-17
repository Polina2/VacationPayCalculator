package ru.neoflex.edu.java.test.calculator.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.neoflex.edu.java.test.calculator.dto.ApiErrorResponse;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CalculatePayExceptionHandler {
    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, BindException.class})
    public ResponseEntity<ApiErrorResponse> handleBadRequest(Exception e) {
        return new ResponseEntity<>(
                createError(
                        e, HttpStatus.BAD_REQUEST.value()
                ), HttpStatus.BAD_REQUEST
        );
    }

    private ApiErrorResponse createError(Exception e, Integer code) {
        return new ApiErrorResponse(
                code, e.toString(), e.getMessage(),
                Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList())
        );
    }
}
