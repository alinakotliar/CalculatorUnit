package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorSinTest{
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
    @MethodSource("sinValuesProvider")
    public void testSin(double angle, double expectedResult) {
        double result = calculator.sin(angle);
        assertEquals(expectedResult, result, DELTA);
    }

    private static Stream<Arguments> sinValuesProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(Math.PI / 6, 0.5),       // sin(pi/6) = 0.5
                Arguments.of(Math.PI / 4, Math.sqrt(2)/2), // sin(pi/4) = sqrt(2)/2
                Arguments.of(Math.PI / 3, Math.sqrt(3)/2), // sin(pi/3) = sqrt(3)/2
                Arguments.of(Math.PI / 2, 1.0)          // sin(pi/2) = 1
        );
    }
}
