/*
 * Author: Kartik Gola
 * Date: 24/06/20, 7:04 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class WordBreak {

    Set<String> set = new HashSet<>();

    private boolean wordBreak(String s, Boolean[] map, int i) {
        if ( i == s.length() )
            return true;
        if ( map[i] != null )
            return map[i];
        for ( int j = i + 1; j <= s.length(); ++j ) {
            String str = s.substring(i, j);
            if ( set.contains(str) && wordBreak(s, map, j) ) {
                return map[i] = true;
            }
        }
        return map[i] = false;
    }

    // Recursive memoized solution
    // Time: O(n), Space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        for ( String wd: wordDict )
            set.add( wd );
        return wordBreak(s, new Boolean[s.length() + 1], 0);
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        final int n = s.length();

        for ( String wd : wordDict )
            set.add( wd );

        // dp[i] = True, if substring dp[0...i) can be made from dictionary
        // c a t s d i p
        // 0 1 2 3 4 5 6 7
        // [cat, cats, dip]
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for ( int i = 1; i <= s.length(); i++) {
            for ( int j = 0; j < i; j++ ) {
                if ( dp[j] && set.contains(s.substring(j, i)) ) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        final int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];

        while ( !q.isEmpty() ) {
            int i = q.poll();
            if ( !visited[i] ) {
                for ( int j = i + 1; j <= n; ++j ) {
                    if ( set.contains( s.substring(i, j) ) ) {
                        q.add(j);
                        if ( j == n )
                            return true;
                    }
                }
                visited[i] = true;
            }
        }

        return false;
    }

}
