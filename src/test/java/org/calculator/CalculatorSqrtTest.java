package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorSqrtTest {
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
    @MethodSource("sqrtValuesProvider")
    public void testSqrt(double value, double expectedResult) {
        double result = calculator.sqrt(value);
        assertEquals(expectedResult, result, 0.001);
    }

    static Stream<Arguments> sqrtValuesProvider() {
        return Stream.of(
                Arguments.of(4.0, 2.0),
                Arguments.of(9.0, 3.0),
                Arguments.of(0.0, 0.0),
                Arguments.of(-16.0, 4.0)
        );
    }
}
