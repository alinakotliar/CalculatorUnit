package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CalculatorSubDoubleTest {
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
    public void testSubDouble(double a, double b, double expected) {
        double delta = 1e-15; // Adjust the delta based on your precision requirements
        assertEquals(expected, calculator.sub(a, b), delta);
    }

    static Stream<Object[]> doubleValuesProvider() {
        return Stream.of(
                new Object[]{5.0, 2.0, 3.0},
                new Object[]{-2.5, 1.5, -4.0},
                new Object[]{0.0, 0.0, 0.0}
        );
    }
}
