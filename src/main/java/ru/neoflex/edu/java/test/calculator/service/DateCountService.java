package ru.neoflex.edu.java.test.calculator.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class DateCountService {
    public Integer countDaysWithoutHolidays(LocalDate startDate, LocalDate endDate) {
        Integer dateDifference = Math.toIntExact(DAYS.between(startDate, endDate));
        return dateDifference;
    }
}
