package profiler_test;

import java.util.Scanner;

public class Fibonacci_Rec {
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        sc.close();

    	long tStart = System.currentTimeMillis();
    	
        int n = 1000;
        for (int i = 1000; i <= n; i++)
            System.out.println(i + ": " + fibonacci(i));
        
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println( elapsedSeconds + " sec");
    }
}
