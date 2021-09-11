/*
 * Author: Kartik Gola
 * Date: 9/11/21, 10:18 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {

    private final Map<String, Integer> map = Map.of("^", 4, "/", 3, "*", 2, "-", 1, "+", 0);

    private boolean isLow(String a, String b) {
        if (!map.containsKey(a))
            return true;
        return map.get(a) < map.get(b);
    }

    private List<String> toPostfix(List<String> infix) {
        Stack<String> st = new Stack<>();
        List<String> pf = new ArrayList<>();
        for (String s : infix) {
            if (map.containsKey(s)) {
                while (!st.empty() && !isLow(st.peek(), s)) {
                    pf.add(st.pop());
                }
                st.push(s);
            } else if (s.equals("(")) {
                st.push(s);
            } else if (s.equals(")")) {
                while (!st.peek().equals("(")) {
                    pf.add(st.pop());
                }
                st.pop();
            } else {
                pf.add(s);
            }
        }
        while (!st.empty()) {
            pf.add(st.pop());
        }
        return pf;
    }

    private int eval(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String s: postfix) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int top = stack.pop();
                if (stack.isEmpty())
                    stack.push(-1 * top);
                else
                    stack.push( stack.pop() - top );
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public int calculate(String s) {
        List<String> al = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                buffer.append(ch);
            } else {
                if (buffer.length() > 0)
                    al.add(buffer.toString());
                buffer = new StringBuilder();
                if (ch != ' ')
                    al.add(Character.toString(ch));
            }
        }
        if (buffer.length() > 0)
            al.add(buffer.toString());
        return eval(toPostfix(al));
    }
}
