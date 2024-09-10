package ru.neoflex.edu.java.test.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.edu.java.test.calculator.repository.IRepository;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class DateCountService {
    private final IRepository<LocalDate> holidayDatesRepository;

    public Integer countDaysWithoutHolidays(LocalDate startDate, LocalDate endDate) {
        Integer dateDifference = Math.toIntExact(DAYS.between(startDate, endDate)) + 1;
        for (LocalDate date : holidayDatesRepository.findAll()) {
            if (!date.isBefore(startDate) && !date.isAfter(endDate)) {
                dateDifference--;
            }
        }
        return dateDifference;
    }
}
