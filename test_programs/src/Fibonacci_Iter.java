/**
 * Created by ZHONGQI on 5/26/17.
 */
public class Fibonacci_Iter {
    public static long fibonacci(int n){
        if(n <= 1){
            return n;
        }
        long fibo = 1;
        long fiboPrev = 1;
        for(int i = 2; i < n; ++i){
            long temp = fibo;
            fibo += fiboPrev;
            fiboPrev = temp;
        }
        return fibo;
    }

    public static void main(String[] args) {
        int n = 1000;
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacci(i));
    }
}
