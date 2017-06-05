package profiler_test;

import java.util.Scanner;

/**
 * Created by ZHONGQI on 6/3/17.
 */
public class InfiniteLoop {
    void a(){
        System.out.println("in a");
    }

    void b() throws InterruptedException {
        while(true){
            System.out.println("in b");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();

        InfiniteLoop loop = new InfiniteLoop();
        loop.a();
        loop.b();
        loop.a();
    }
}
