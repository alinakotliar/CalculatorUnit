package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorTgTest {
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
    @MethodSource("tgValuesProvider")
    public void testTg(double a, double expectedResult) {
        double result = calculator.tg(a);
        assertEquals(expectedResult, result, 0.001);
    }

    static Stream<Arguments> tgValuesProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),              // tan(0) = 0
                Arguments.of(-Math.PI / 4, -1.0)     // tan(-pi/4) = -1
        );
    }
}
