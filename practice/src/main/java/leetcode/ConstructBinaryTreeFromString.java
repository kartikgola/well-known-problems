/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreeFromString {

    public TreeNode str2tree(String s) {
        final Stack<TreeNode> st = new Stack<>();
        final StringBuilder sb = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == ')') {
                if (sb.length() > 0) { // push the value present in 'sb'
                    st.push(new TreeNode(Integer.parseInt(sb.toString())));
                    sb.delete(0, sb.length());
                }
                if (ch == ')') { // start popping
                    TreeNode top = st.pop();
                    if (st.peek().left == null)
                        st.peek().left = top;
                    else
                        st.peek().right = top;
                }
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() > 0) // In case s = "4"
            st.push(new TreeNode(Integer.parseInt(sb.toString())));

        return st.isEmpty() ? null : st.pop();
    }
}
