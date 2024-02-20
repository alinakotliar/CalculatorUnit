package org.calculator;

import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.Assert.assertEquals;

public class CalculatorSumLongTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @ParameterizedTest
    @MethodSource("longValuesProvider")
    @Execution(ExecutionMode.CONCURRENT)
    public void testSumLong(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    static Stream<Object[]> longValuesProvider() {
        return Stream.of(
                new Object[]{1L, 2L, 3L},
                new Object[]{-5L, 3L, -2L},
                new Object[]{0L, 0L, 0L}
        );
    }
}