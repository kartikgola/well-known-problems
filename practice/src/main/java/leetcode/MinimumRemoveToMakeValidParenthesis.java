/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        // decides whether a character will be kept in ans or not
        boolean[] keep = new boolean[s.length()];

        // We keep all non-parenthesis chars
        // We keep all matching (, ) pairs
        // Others are by default not kept (default false)
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    keep[st.pop()] = true;
                    keep[i] = true;
                }
            } else {
                keep[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keep.length; ++i) {
            if (keep[i])
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
