package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorCosTest{
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
    @MethodSource("cosValuesProvider")
    @Execution(ExecutionMode.CONCURRENT)
    public void testCos(double angle, double expectedResult) {
        double result = calculator.cos(angle);
        assertEquals(expectedResult, result, DELTA);
    }

    private static Stream<Arguments> cosValuesProvider() {
        return Stream.of(
                Arguments.of(0.0, 1.0),
                Arguments.of(Math.PI / 6, Math.sqrt(3)/2), // cos(pi/6) = sqrt(3)/2
                Arguments.of(Math.PI / 4, Math.sqrt(2)/2), // cos(pi/4) = sqrt(2)/2
                Arguments.of(Math.PI / 3, 0.5),            // cos(pi/3) = 0.5
                Arguments.of(Math.PI / 2, 0.0)             // cos(pi/2) = 0
        );
    }
}
