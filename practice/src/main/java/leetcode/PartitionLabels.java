/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        if ( S.isEmpty() )
            return new ArrayList<Integer>();

        final int n = S.length();
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for ( int i = 0; i < 26; ++i )
            map[(char)('a' + i) - 'a'] = S.lastIndexOf( (char)('a' + i) );

        int breakAt = -1;
        int lastBreak = -1;
        for ( int i = 0; i < S.length(); ++i ) {
            breakAt = Math.max(breakAt, map[S.charAt(i) - 'a']);
            if ( i == breakAt ) {
                res.add(i - lastBreak);
                lastBreak = breakAt;
                breakAt = -1;
            }
        }

        return res;
    }

}
