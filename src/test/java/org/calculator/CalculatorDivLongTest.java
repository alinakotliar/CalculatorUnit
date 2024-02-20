package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorDivLongTest {

    private static final double DELTA = 0.001;
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
    public void testDivLong(long a, long b, long expected) {
        if (b == 0) {
            assertDivideByZeroException(calculator, a);
        } else {
            assertLongDivResult(calculator, a, b, expected);
        }
    }

    private static Stream<Arguments> longValuesProvider() {
        return Stream.of(
                Arguments.of(10L, 2L, 5L),
                Arguments.of(15L, 3L, 5L),
                Arguments.of(8L, 4L, 2L)
        );
    }

    private void assertDivideByZeroException(Calculator calculator, double value) {
        try {
            calculator.div(value, 0);
            fail("Expected NumberFormatException was not thrown");
        } catch (NumberFormatException e) {
            assertEquals("Attempt to divide by zero", e.getMessage());
        }
    }

    private void assertLongDivResult(Calculator calculator, long a, long b, long expected) {
        long result = calculator.div(a, b);
        assertEquals(expected, result);
    }
}
