package ru.neoflex.edu.java.test.calculator.aggregator;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import ru.neoflex.edu.java.test.calculator.dto.CalculatePayResponse;

public class CalculatePayResponseAggregator implements ArgumentsAggregator {
    @Override
    public CalculatePayResponse aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new CalculatePayResponse(argumentsAccessor.getDouble(4));
    }
}
