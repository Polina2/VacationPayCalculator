package ru.neoflex.edu.java.test.calculator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import ru.neoflex.edu.java.test.calculator.controller.CalculatePayController;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayRequest;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayResponse;
import ru.neoflex.edu.java.test.calculator.repository.HolidayDatesRepository;
import ru.neoflex.edu.java.test.calculator.service.CalculatePayService;
import ru.neoflex.edu.java.test.calculator.service.DateCountService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CalculatePayControllerTest {
    private static final double DELTA = 1e-6;

    private final CalculatePayController calculatePayController = new CalculatePayController(
            new CalculatePayService(), new DateCountService(new HolidayDatesRepository())
    );

    @ParameterizedTest
    @CsvSource({
            ",,,",
            "12345,,,",
            "23456,,,2021-02-01"
    })
    public void nullPointerExceptionTest(
            @AggregateWith(CalculatePayRequestAggregator.class) CalculatePayRequest request
    ) {
        Assertions.assertThrows(NullPointerException.class, () -> {calculatePayController.calculate(request);});
    }

    @ParameterizedTest
    @CsvSource({
            "34567,1,2024-03-01,",
            "56789,,2024-08-08,2024-08-01",
            "67890,9,2024-08-01,2024-08-08",
            "78901,,-2024-09-23,"
    })
    public void illegalArgumentExceptionTest(
            @AggregateWith(CalculatePayRequestAggregator.class) CalculatePayRequest request
    ) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {calculatePayController.calculate(request);});
    }

    @Test
    public void validationTest(
    ) {
        CalculatePayRequest request = new CalculatePayRequest(45678.0, -1, null, null);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CalculatePayRequest>> violations = validator.validate(request);

        Assertions.assertFalse(violations.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "36625,10,,,12500",
            "123456,12,,2023-02-13,50562.1843",
            "90123,,2024-05-01,2024-05-10,24606.962457",
            "90123,8,2024-05-01,2024-05-10,24606.962457"
    })
    public void withoutErrorTest(
            @AggregateWith(CalculatePayRequestAggregator.class) CalculatePayRequest request,
            @AggregateWith(CalculatePayResponseAggregator.class) CalculatePayResponse expectedResponse
    ) {
        CalculatePayResponse actualResponse = calculatePayController.calculate(request);

        Assertions.assertEquals(expectedResponse.getVacationPay(), actualResponse.getVacationPay(), DELTA);
    }
}
