package ru.neoflex.edu.java.test.calculator.repository;

import org.springframework.stereotype.Repository;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class HolidayDatesRepository implements IRepository<MonthDay> {

    private final List<MonthDay> holidays = Arrays.asList(
            MonthDay.of(1, 1),
            MonthDay.of(1, 2),
            MonthDay.of(1, 3),
            MonthDay.of(1, 4),
            MonthDay.of(1, 5),
            MonthDay.of(1, 6),
            MonthDay.of(1, 7),
            MonthDay.of(1, 8),
            MonthDay.of(2, 23),
            MonthDay.of(3, 8),
            MonthDay.of(5, 1),
            MonthDay.of(5, 9),
            MonthDay.of(6, 12),
            MonthDay.of(11, 4)
    );

    @Override
    public List<MonthDay> findAll() {
        return new ArrayList<>(holidays);
    }

    @Override
    public void add(MonthDay object) {
        holidays.add(object);
    }

    @Override
    public void remove(MonthDay object) {
        holidays.remove(object);
    }
}
