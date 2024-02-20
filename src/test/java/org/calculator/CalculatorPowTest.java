package org.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorPowTest {
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
    @MethodSource("powValuesProvider")
    public void testPow(double a, double b, double expectedResult) {

        double result = calculator.pow(a, b);
        assertEquals(expectedResult, result, 0.001);
    }

    static Stream<Arguments> powValuesProvider() {
        return Stream.of(
                Arguments.of(2.0, 3.0, 8.0),
                Arguments.of(3.0, 2.0, 9.0),
                Arguments.of(0.0, 5.0, 0.0),
                Arguments.of(5.0, 0.0, 1.0)
        );
    }
}
