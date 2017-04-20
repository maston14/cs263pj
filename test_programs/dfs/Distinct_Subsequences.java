/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class Distinct_Subsequences {

	public static int numDistinct( String s, String t ) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] ch_a = s.toCharArray();
        for ( int i = 0; i < ch_a.length; i++ ) {
            if ( !map.containsKey( ch_a[i] ) ) {
                List<Integer> list = new ArrayList<>();
                list.add( i );
                map.put( ch_a[i], list );
            } else {
                List<Integer> list = map.get( ch_a[i] );
                list.add( i );
            }
        }
        return helper( map, t, 0, -1 );

    }

    public static int helper( Map<Character, List<Integer>> map, String t, int pos, int lastPos ) {
        if ( pos > t.length() - 1 ) return 0;

        char ch = t.charAt( pos );
        int count = 0;
        if ( !map.containsKey( ch ) )
            return 0;
        List<Integer> list = map.get( ch );
        if ( pos == t.length() - 1 ) {
            for ( Integer I : list ) {
                if ( I > lastPos )
                    count++;
            }
        } else {
            for ( Integer I : list ) {
                if ( I > lastPos ) {
                    count += helper( map, t, pos + 1, I );
                }
            }
        }
        return count;

    }

    public static void public static void main( String[] args ) {
    	Assert.assertEquals( numDistinct("ckkcharrcokast","cat"), 5 );
    	Assert.assertEquals( numDistinct("wryhsdkjfhqgifduhasdfssdsfxcbvdgaffskjdf","sjf"), 13 );
    	Assert.assertEquals( numDistinct("aaaaaffffffiouhjnklhkhkjhgggwwwqqqqq","afgwq"), 1350 );
    	Assert.assertEquals( numDistinct("zxfgwefgksdfbhwaksdf","s"), 2 );
    	Assert.assertEquals( numDistinct("aaaaaaaaaaaaa","a"), 13 );
    	Assert.assertEquals( numDistinct("zcmadhkloqjlkjhaaafskjsdhfkasdasdasd","asd"), 66 );
    	Assert.assertEquals( numDistinct("zcvzkfjhsakjfhazvzcasfxgvsdfzgzfasf","zf"), 24 );
    }
}