/**
 * Created by ZHONGQI on 5/26/17.
 */
public class Fibonacci_Rec {
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 1000;
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacci(i));
    }
}
