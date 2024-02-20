package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorDivDoubleTest {
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
    @MethodSource("doubleValuesProvider")
    public void testDivDouble(double a, double b, double expected) {
        if (b == 0.0) {
            assertDivideByZeroException(calculator, a);
        } else {
            assertDoubleDivResult(calculator, a, b, expected);
        }
    }

    private static Stream<Arguments> doubleValuesProvider() {
        return Stream.of(
                Arguments.of(10.0, 2.0, 5.0),
                Arguments.of(15.0, 3.0, 5.0),
                Arguments.of(8.0, 4.0, 2.0)
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

    private void assertDoubleDivResult(Calculator calculator, double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertEquals(expected, result, DELTA);
    }
}

