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
public class CalculatorSumDoubleTest {
    private final double a;
    private final double b;
    private final double expectedResult;
    private Calculator calculator;

    public CalculatorSumDoubleTest(double a, double b, double expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 2.0, 3.0},
                {0.0, 0.0, 0.0},
                {-1.0, 1.0, 0.0},
                {2.5, 3.5, 6.0}
        });
    }

    @Test
    public void testSum() {
        double result = calculator.sum(a, b);
        assertEquals(expectedResult, result, 0.001);
    }
}
