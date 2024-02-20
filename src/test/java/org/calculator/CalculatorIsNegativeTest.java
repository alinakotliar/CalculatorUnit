package org.calculator;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class CalculatorIsNegativeTest {
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
    @ValueSource(longs = {-5, 0, 5})
    public void testIsNegative(long a) {
        boolean result = calculator.isNegative(a);
        assertEquals(a < 0, result);
    }
}
