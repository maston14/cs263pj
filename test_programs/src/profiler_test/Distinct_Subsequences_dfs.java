package profiler_test;

/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Distinct_Subsequences_dfs {

    public static int numDistinct(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] ch_a = s.toCharArray();
        for (int i = 0; i < ch_a.length; i++) {
            if (!map.containsKey(ch_a[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch_a[i], list);
            } else {
                List<Integer> list = map.get(ch_a[i]);
                list.add(i);
            }
        }
        return helper(map, t, 0, -1);

    }

    public static int helper(Map<Character, List<Integer>> map, String t, int pos, int lastPos) {
        if (pos > t.length() - 1)
            return 0;
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
        char ch = t.charAt(pos);
        int count = 0;
        if (!map.containsKey(ch))
            return 0;
        List<Integer> list = map.get(ch);
        if (pos == t.length() - 1) {
            for (Integer I : list) {
                if (I > lastPos)
                    count++;
            }
        } else {
            for (Integer I : list) {
                if (I > lastPos) {
                    count += helper(map, t, pos + 1, I);
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type anything to run: ");
        String name = sc.next();
        sc.close();

        double avg = 0;
        for (int j = 0; j < 10; j++) {
            long tStart = System.currentTimeMillis();

            for (int i = 0; i < 1000000; i++) {
                Assert.assertEquals(numDistinct("ckkcharrcokast", "cat"), 5);
                Assert.assertEquals(numDistinct("wryhsdkjfhqgifduhasdfssdsfxcbvdgaffskjdf", "sjf"), 13);
                Assert.assertEquals(numDistinct("aaaaaffffffiouhjnklhkhkjhgggwwwqqqqq", "afgwq"), 1350);
                Assert.assertEquals(numDistinct("zxfgwefgksdfbhwaksdf", "s"), 2);
                Assert.assertEquals(numDistinct("aaaaaaaaaaaaa", "a"), 13);
                Assert.assertEquals(numDistinct("zcmadhkloqjlkjhaaafskjsdhfkasdasdasd", "asd"), 66);
                Assert.assertEquals(numDistinct("zcvzkfjhsakjfhazvzcasfxgvsdfzgzfasf", "zf"), 24);
            }

            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            double elapsedSeconds = tDelta / 1000.0;
            System.out.println(elapsedSeconds + " sec");
            avg += elapsedSeconds;
        }
        System.out.println("average: " + avg / 10 + " sec");
    }
}
