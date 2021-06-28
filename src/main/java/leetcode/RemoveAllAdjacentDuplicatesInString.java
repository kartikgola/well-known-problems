/*
 * Author: Kartik Gola
 * Date: 6/28/21, 3:12 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
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
