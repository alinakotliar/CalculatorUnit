package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorMultDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
    private static final double DELTA = 0.001;

    @ParameterizedTest
    @MethodSource("doubleValuesProvider")
    public void testMultDouble(double a, double b, double expectedResult) {
        double result = calculator.mult(a, b);
        assertDoubleEquals(expectedResult, result, DELTA);
    }

    private static Stream<Arguments> doubleValuesProvider() {
        return Stream.of(
                Arguments.of(2.5, 4.0, 10.0),
                Arguments.of(0.0, 3.0, 0.0),
                Arguments.of(-3.0, 2.0, -6.0)
        );
    }

    private void assertDoubleEquals(double expectedResult, double actual, double delta) {
        assertEquals(expectedResult, actual, delta);
    }
}
