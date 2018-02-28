package exercises.series;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.exercises.series.Fibonacci;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testSeriesIterative() {
        int[] actual = Fibonacci.getSeriesIterative(8);
        int[] expected = { 1, 1, 2, 3, 5, 8, 13, 21 };
        assertArrayEquals(expected, actual);

        actual = Fibonacci.getSeriesRecursive(8);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFibonacci() {
        assertEquals(3, Fibonacci.getNthValueIterative(4));
        assertEquals(3, Fibonacci.getNthValueRecursive(4));

        assertEquals(1, Fibonacci.getNthValueIterative(1));
        assertEquals(1, Fibonacci.getNthValueRecursive(1));

        assertEquals(1, Fibonacci.getNthValueIterative(2));
        assertEquals(1, Fibonacci.getNthValueRecursive(2));

        assertEquals(0, Fibonacci.getNthValueIterative(0));
        assertEquals(0, Fibonacci.getNthValueRecursive(0));

        assertEquals(0, Fibonacci.getNthValueIterative(-1));
        assertEquals(0, Fibonacci.getNthValueRecursive(-1));

        assertEquals(0, Fibonacci.getNthValueIterative(999999999));
        assertEquals(0, Fibonacci.getNthValueRecursive(999999999));

        assertEquals(0, Fibonacci.getNthValueIterative(500));
        assertEquals(0, Fibonacci.getNthValueRecursive(100));
        // recursive version takes too long...

        assertEquals(21, Fibonacci.getNthValueIterative(8));
        assertEquals(21, Fibonacci.getNthValueRecursive(8));

        assertEquals(55, Fibonacci.getNthValueIterative(10));
        assertEquals(55, Fibonacci.getNthValueRecursive(10));
    }
}
