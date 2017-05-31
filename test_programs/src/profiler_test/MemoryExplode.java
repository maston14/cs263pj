package profiler_test;

import java.util.ArrayList;
import java.util.List;

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
        List list = new ArrayList<Integer>(100000);
        // 对list进行处理
        a(j);
    }

    public static void main(String[] args) {

    	MemoryExplode ttt = new MemoryExplode();
        //ttt.callback();
        ttt.a(1);
    }
}
