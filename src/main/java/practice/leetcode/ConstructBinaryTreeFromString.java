/*
 * Author: Kartik Gola
 * Date: 3/20/21, 1:23 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/construct-binary-tree-from-string/
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

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
