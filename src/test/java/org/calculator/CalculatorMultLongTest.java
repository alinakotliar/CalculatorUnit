package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorMultLongTest {
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
    public void testMultLong(long a, long b, long expectedResult) {
        long result = calculator.mult(a, b);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> longValuesProvider() {
        return Stream.of(
                Arguments.of(2L, 3L, 6L),
                Arguments.of(0L, 5L, 0L),
                Arguments.of(-2L, 4L, -8L)
        );
    }
}
