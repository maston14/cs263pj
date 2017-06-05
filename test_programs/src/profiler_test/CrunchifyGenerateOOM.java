package profiler_test;

import java.util.Scanner;

/**
 * Created by ZHONGQI on 6/4/17.
 */
public class CrunchifyGenerateOOM {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        sc.close();

        CrunchifyGenerateOOM memoryTest = new CrunchifyGenerateOOM();
        memoryTest.generateOOM();
    }

    public void generateOOM() throws Exception {
        int iteratorValue = 20;
        System.out.println("\n=================> OOM test started..\n");
        for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
            System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
            int loop1 = 2;
            if( iteratorValue <= 195312500) {
                int[] memoryFillIntVar = new int[iteratorValue];
            // feel memoryFillIntVar array in loop..
            do {
                memoryFillIntVar[loop1] = 0;
                loop1--;
            } while (loop1 > 0);
            }else{
                String[] s = new String[iteratorValue];
                s[0] = "sss";
            }
                iteratorValue = iteratorValue * 5;
            System.out.println("\nRequired Memory for next loop: " + iteratorValue);
            Thread.sleep(1000);
        }

    }
}