package ru.neoflex.edu.java.test.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.neoflex.edu.java.test.calculator.repository.HolidayDatesRepository;
import ru.neoflex.edu.java.test.calculator.service.DateCountService;

import java.time.LocalDate;

public class DateCountServiceTest {
    private final DateCountService dateCountService = new DateCountService(new HolidayDatesRepository());

    @ParameterizedTest
    @CsvSource({
            "2024-01-03, 2024-01-06, 0",
            "2024-01-01, 2024-01-08, 0",
            "2024-01-01, 2024-01-09, 1",
            "2024-02-22, 2024-02-24, 2",
            "2023-03-08, 2023-03-10, 2",
            "2023-04-25, 2023-05-01, 6",
            "2023-04-28, 2023-05-10, 11",
            "2023-10-23, 2024-10-23, 353",
            "0102-08-05, 0102-09-05, 32"
    })
    public void datesWithoutErrorTest(LocalDate startDate, LocalDate endDate, int expectedDaysCount) {
        int actualDaysCount = dateCountService.countDaysWithoutHolidays(startDate, endDate);

        Assertions.assertEquals(expectedDaysCount, actualDaysCount);
    }
}
