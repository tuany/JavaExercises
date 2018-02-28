package org.exercises.numbers;

public class PrimeNumber {
    
    private static final int MAX = 10000000;

    /**
     * Given a number n, identifies if is a prime number or not.
     * @param n integer number to be tested
     * @return <code>true</code> if is prime, <code>false</code> otherwise.
     */
    public static boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    /**
     * Given a number <code>n</code>, returns the next prime number after <code>n</code>.
     * @param n <code>int</code>
     * @return <code>int</code> -1 if no prime is found.
     */
    public static int nextPrimeNumber(int n) {
        for(int i = n + 1; i < MAX; i++) {
            if(isPrime(i)) return i;
        }
        return -1;
    }

    /**
     * Return a series with n first prime numbers.
     * @param n <code>int</code> size of the series 
     * @return <code>int[]</code>
     */
    public static int[] getPrimes(int n) {
        if (n <= 0)
            return new int[] {};
        int[] r = new int[n];
        r[0] = nextPrimeNumber(1);
        for (int i = 1; i < n; i++) {
            r[i] = nextPrimeNumber(r[i - 1]);
        }

        return r;
    }
}
