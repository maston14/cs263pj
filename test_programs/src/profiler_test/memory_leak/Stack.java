package profiler_test.memory_leak;

import java.util.Scanner;

/**
 * Created by ZHONGQI on 5/16/17.
 */

// Internal Data Structure
public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int pointer;
    public Stack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        pointer = -1;
    }
    public void push(int j) {
        stackArray[++pointer] = j;
    }
    public int pop() {
        return stackArray[pointer--];
    }
    public int peek() {
        return stackArray[pointer];
    }
    public boolean isEmpty() {
        return (pointer == -1);
    }
    public boolean isFull() {
        return (pointer == maxSize - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Type anything to run: ");
        String name = sc.next();

        int stack_size = 1000000;

        Stack stack = new Stack(stack_size);
        for(int i = 0; i < stack_size; i++)
        {
            stack.push(i);
        }
        for(int i = 0; i < stack_size; i++)
        {
            int element = stack.pop();
            //System.out.println("Poped element is "+ element);
        }

        System.out.println("Type anything to stop: ");
        name = sc.next();
        sc.close();

    }
}

