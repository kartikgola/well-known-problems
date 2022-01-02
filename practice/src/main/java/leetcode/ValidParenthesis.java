/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
