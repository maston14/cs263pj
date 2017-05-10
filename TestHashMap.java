import java.util.*;

public class TestHashMap {
  public static void doTest() {
    Map<String, Integer> testmap = new HashMap<String, Integer>();
    for (int i = 0; i < 10000000; i++) {
      String s = Integer.toString(i);
      testmap.put(s, i);
      int t = testmap.get(s);
      if (t % 100000 == 0) {
        System.out.println(t);
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      long start = System.currentTimeMillis();
      doTest();
      long end = System.currentTimeMillis();
      System.out.printf("Round %d: Time duration: %dms\n", i, (end - start));
      // System.gc();
    }
  }
}

