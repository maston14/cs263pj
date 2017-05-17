package memory_leak;

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
        Stack stack = new Stack(10000);
        for(int i = 0; i < 10000; i++)
        {
            stack.push(i);
        }
        for(int i = 0; i < 10000; i++)
        {
            int element = stack.pop();
            System.out.println("Poped element is "+ element);
        }
    }
}
