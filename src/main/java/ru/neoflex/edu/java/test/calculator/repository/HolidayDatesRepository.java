package ru.neoflex.edu.java.test.calculator.repository;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class HolidayDatesRepository implements IRepository<LocalDate> {

    private final List<LocalDate> holidays = Arrays.asList(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),
            LocalDate.of(2024, 1, 7),
            LocalDate.of(2024, 1, 8),
            LocalDate.of(2024, 2, 23),
            LocalDate.of(2024, 3, 8),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 9),
            LocalDate.of(2024, 6, 12),
            LocalDate.of(2024, 11, 4)
    );

    @Override
    public List<LocalDate> findAll() {
        return new ArrayList<>(holidays);
    }

    @Override
    public void add(LocalDate object) {
        holidays.add(object);
    }

    @Override
    public void remove(LocalDate object) {
        holidays.remove(object);
    }
}
