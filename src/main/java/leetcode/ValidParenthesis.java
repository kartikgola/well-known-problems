/*
 * Author: Kartik Gola
 * Date: 20/01/2021, 19:10
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/valid-parentheses/
 */

package leetcode;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;
                switch(ch) {
                    case ')': if (st.pop() != '(') return false; break;
                    case ']': if (st.pop() != '[') return false; break;
                    case '}': if (st.pop() != '{') return false; break;
                }
            }
        }
        return st.isEmpty();
    }
}
