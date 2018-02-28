package org.exercises.series;

public class Fibonacci {

    private final static int MAX_VALUE = 100;

    public static int[] getSeriesIterative(int n) {
        if(n  <= 0) return new int[]{};
        if(n >= MAX_VALUE) return new int[]{};

        int[] arr = new int[n];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int[] getSeriesRecursive(int n) {
        if (n <= 0)
            return new int[] {};
        if (n >= MAX_VALUE)
            return new int[] {};

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getNthValueRecursive(i + 1);
        }
        return arr;
    }

    public static int getNthValueIterative(int n) {
        if(n <= 0) return 0;
        if(n >= MAX_VALUE) return 0;
        
        int f = 1;
        int s = 1;
        int fibo = 1;
        for (int i = 3; i <= n; i++) {
            fibo = s + f;
            f = s;
            s = fibo;
        }
        return fibo;
    }

    public static int getNthValueRecursive(int n) {
        if(n <= 0) return 0;
        if(n >= MAX_VALUE) return 0;
        if(n <= 2) return 1;
        return getNthValueRecursive(n - 2) + getNthValueRecursive(n - 1);
    }
}
