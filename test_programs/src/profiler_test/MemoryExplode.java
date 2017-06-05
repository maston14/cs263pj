package profiler_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryExplode {
    static int level = 1;
    public void callback(){
        level++;
        System.out.println("level:"+level);
        callback();
    }

    public void a(int j) {
        System.out.println(j);
        j++;
        if (j == 10000)
            return;
        List list = new ArrayList<DummyObj>(100000);
        // 对list进行处理
        a(j);
    }

    public void b() {
        List list = new ArrayList<DummyObj>(1000000);
        long i = 0;
        while(true) {
            list.add(new DummyObj(String.valueOf(i++)));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        sc.close();

    	MemoryExplode ttt = new MemoryExplode();
        //ttt.callback();
        //ttt.a(1);
        ttt.b();
    }

    private class DummyObj{
        String p;
        DummyObj(String s){
            p = s;
        }

    }
}
