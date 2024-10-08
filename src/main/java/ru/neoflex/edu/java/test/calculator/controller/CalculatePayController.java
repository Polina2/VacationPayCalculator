package ru.neoflex.edu.java.test.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayRequest;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayResponse;
import ru.neoflex.edu.java.test.calculator.service.CalculatePayService;
import ru.neoflex.edu.java.test.calculator.service.DateCountService;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CalculatePayController {
    private final CalculatePayService calculatePayService;
    private final DateCountService dateCountService;

    @GetMapping("/calculate")
    public CalculatePayResponse calculate(@Valid CalculatePayRequest request)
            throws NullPointerException, IllegalArgumentException {
        boolean isDaysCountNull = request.getDaysCount() == null;
        boolean isStartDateNull = request.getStartDate() == null;
        LocalDate endDate = (request.getEndDate() == null ? LocalDate.now() : request.getEndDate());

        if (isDaysCountNull && isStartDateNull)
            throw new NullPointerException("The number of days or dates of vacation must be specified");
        if (!isStartDateNull) {
            if (request.getStartDate().getYear() < 0 || endDate.getYear() < 0)
                throw new IllegalArgumentException("The year should be positive");
            Integer dateDifference =
                    dateCountService.countDaysWithoutHolidays(
                            request.getStartDate(),
                            endDate
                    );
            if (dateDifference <= 0)
                throw new IllegalArgumentException("Start date should be earlier than end date");
            if (isDaysCountNull || request.getDaysCount().equals(dateDifference))
                return new CalculatePayResponse(
                        calculatePayService.calculatePay(request.getAvgSalary(), dateDifference)
                );
            throw new IllegalArgumentException(
                    "Given dates have " + dateDifference + " days of vacation but you gave " + request.getDaysCount()
            );
        }
        return new CalculatePayResponse(
                calculatePayService.calculatePay(request.getAvgSalary(), request.getDaysCount())
        );
    }
}
