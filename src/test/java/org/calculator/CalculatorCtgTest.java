package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorCtgTest {
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
    @MethodSource("ctgValuesProvider")
    public void testCtg(double a, double expectedResult) {
        double result = calculator.ctg(a);
        assertEquals(expectedResult, result, 0.001);
    }

    static Stream<Arguments> ctgValuesProvider() {
        return Stream.of(// cot(pi/4) is undefined
                Arguments.of(0.0, Double.POSITIVE_INFINITY),  // cot(0) is undefined
                Arguments.of(Math.PI / 2, 0.0)              // cot(pi/2) = 0

        );
    }
}
