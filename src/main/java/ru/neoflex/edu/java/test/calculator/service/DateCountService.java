package ru.neoflex.edu.java.test.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.edu.java.test.calculator.repository.IRepository;

import java.time.LocalDate;
import java.time.MonthDay;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class DateCountService {
    private final IRepository<MonthDay> holidayDatesRepository;

    public Integer countDaysWithoutHolidays(LocalDate startDate, LocalDate endDate) {
        Integer dateDifference = Math.toIntExact(DAYS.between(startDate, endDate)) + 1;
        for (MonthDay date : holidayDatesRepository.findAll()) {
            for (int year = startDate.getYear(); year <= endDate.getYear(); year++) {
                if (!LocalDate.of(year, date.getMonth(), date.getDayOfMonth()).isBefore(startDate) &&
                        !LocalDate.of(year, date.getMonth(), date.getDayOfMonth()).isAfter(endDate)) {
                    dateDifference--;
                }
            }
        }
        return dateDifference;
    }
}
