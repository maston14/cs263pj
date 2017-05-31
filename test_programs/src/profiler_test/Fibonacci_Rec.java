package profiler_test;

public class Fibonacci_Rec {
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
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
