package org.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorSubLongTest {

    private final long a;
    private final long b;
    private final long expectedResult;
    private Calculator calculator;

    public CalculatorSubLongTest(long a, long b, long expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {7L, 3L, 4L},   // Test case 1: 7L - 3L = 4L
                {10L, 5L, 5L},  // Test case 2: 10L - 5L = 5L
        });
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testSubLong() {
        long result = calculator.sub(a, b);
        assertEquals(expectedResult, result);
    }
}