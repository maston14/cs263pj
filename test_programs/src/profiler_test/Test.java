package profiler_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ZHONGQI on 6/3/17.
 */
public class Test {
    public static List<Integer> st_list = new ArrayList<>(1000000);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        int i = 0;
        while(i < 10000000){
            st_list.add(i++);
        }

        System.out.println("Type anything to stop: ");
        name = sc.next();
        sc.close();
    }
}
