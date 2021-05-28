/*
 * Author: Kartik Gola
 * Date: 8/7/20 12:05 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/remove-invalid-parentheses/
 */

package leetcode;

import util.Pair;

import java.util.*;

public class RemoveInvalidParentheses {

    private boolean isValid(String s) {
        int count = 0;
        for ( char ch : s.toCharArray() ) {
            if ( ch == '(' )
                ++count;
            else if ( ch == ')' ) {
                if ( count > 0 )
                    --count;
                else
                    return false;
            }

        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(s, 0));
        List<String> ans = new ArrayList<>();

        while ( !q.isEmpty() ) {
            Pair<String, Integer> p = q.poll();
            String key = p.getKey();
            if ( isValid(key) ) {
                ans.add(key);
            } else if ( ans.isEmpty() ) {
                // Start at previous parenthesis's removal index
                for ( int i = p.getValue(); i < key.length(); ++i ) {
                    if ( key.charAt(i) == '(' || key.charAt(i) == ')' ) {
                        // 2nd check in below condition makes sure that we are not processing the same '(' or ')' again & again
                        // Example, (((() <- here, we only process the first '(' among the first 4 '('
                        if ( i == p.getValue() || key.charAt(i) != key.charAt(i - 1) ) {
                            q.add(new Pair<>(key.substring(0, i) + key.substring(i + 1), i));
                        }
                    }
                }
            }
        }

        return ans;
    }
}
