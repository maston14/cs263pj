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
        if ( s == null || t == null )
            return 0;
        int sl = s.length();
        int tl = t.length();
        if ( sl == 0 || tl == 0 || tl > sl ) return 0;
        int[][] dp = new int[tl][sl];
        if ( s.charAt( 0 ) == t.charAt( 0 ) )
            dp[0][0] = 1;
        for ( int i = 1; i < sl; i++ ) {
            dp[0][i] = dp[0][i - 1];
            if ( s.charAt( i ) == t.charAt( 0 ) )
                dp[0][i]++;
        }

        for ( int i = 1; i < tl; i++ ) {
            for ( int j = i; j < sl; j++ ) {q
                dp[i][j] = dp[i][j - 1];
                if ( s.charAt( j ) == t.charAt( i ) )
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[tl - 1][sl - 1];
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