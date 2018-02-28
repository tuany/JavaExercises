package exercises.numbers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.exercises.numbers.PrimeNumber;
import org.junit.Test;

public class PrimeNumberTest {

    @Test
    public void testNotPrimeNumbers() {
        assertFalse(PrimeNumber.isPrime(4));
        assertFalse(PrimeNumber.isPrime(0));
        assertFalse(PrimeNumber.isPrime(1));
        assertFalse(PrimeNumber.isPrime(15));
        assertFalse(PrimeNumber.isPrime(-3));
    }

    @Test
    public void testPrimeNumbers() {
        assertTrue(PrimeNumber.isPrime(2));
        assertTrue(PrimeNumber.isPrime(7));
        assertTrue(PrimeNumber.isPrime(19));
        assertTrue(PrimeNumber.isPrime(103));
    }

    @Test
    public void testNextPrimeNumber() {
        assertEquals(5, PrimeNumber.nextPrimeNumber(4));
        assertEquals(5, PrimeNumber.nextPrimeNumber(3));
        assertEquals(19, PrimeNumber.nextPrimeNumber(17));
        assertEquals(2, PrimeNumber.nextPrimeNumber(-3));
        assertEquals(2, PrimeNumber.nextPrimeNumber(0));
        assertEquals(2, PrimeNumber.nextPrimeNumber(1));
        assertEquals(2, PrimeNumber.nextPrimeNumber(-9999999));
        assertEquals(103, PrimeNumber.nextPrimeNumber(101));
    }

    @Test
    public void testPrimeNumberSeries() {
        assertArrayEquals(new int[] {}, PrimeNumber.getPrimes(0));
        assertArrayEquals(new int[] {}, PrimeNumber.getPrimes(-1));
        assertArrayEquals(new int[] { 2 }, PrimeNumber.getPrimes(1));
        assertArrayEquals(new int[] { 2, 3, 5 }, PrimeNumber.getPrimes(3));
        assertArrayEquals(new int[] { 2, 3, 5, 7 }, PrimeNumber.getPrimes(4));
        assertArrayEquals(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 },
                PrimeNumber.getPrimes(10));
    }
}
