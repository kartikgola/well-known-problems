/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(ch);
            } else {
                if (st.peek() == ch)
                    st.pop();
                else
                    st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty())
            ans.append(st.pop());
        return ans.reverse().toString();
    }
}
