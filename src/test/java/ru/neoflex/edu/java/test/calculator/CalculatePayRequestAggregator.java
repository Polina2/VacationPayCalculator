package ru.neoflex.edu.java.test.calculator;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayRequest;

import java.time.LocalDate;

public class CalculatePayRequestAggregator implements ArgumentsAggregator {
    @Override
    public CalculatePayRequest aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext)
            throws ArgumentsAggregationException {
        return new CalculatePayRequest(
                argumentsAccessor.getDouble(0),
                argumentsAccessor.getInteger(1),
                argumentsAccessor.get(2, LocalDate.class),
                argumentsAccessor.get(3, LocalDate.class)
                );
    }
}
