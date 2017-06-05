package profiler_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ZHONGQI on 6/4/17.
 */
public class KeylessEntry {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        sc.close();

        Map<Key,String> m = new HashMap<>();
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < 10000; i++)
                if (!m.containsKey(new Key(i)))
                    m.put(new Key(i), "Number:" + i);
                else
                    flag = false;
        }

    }
}
