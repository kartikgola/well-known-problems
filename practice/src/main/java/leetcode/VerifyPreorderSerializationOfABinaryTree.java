/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;
import java.util.StringTokenizer;

public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#"))
            return true;

        Stack<String> sk = new Stack<>();
        StringTokenizer st = new StringTokenizer(preorder, ",");
        String root = null;

        while (st.hasMoreTokens()) {
            String tk = st.nextToken();
            if (tk.equals("#")) {
                if (sk.isEmpty())
                    return false;
                // [..,4,L becomes [..,4,L,R
                else if (sk.peek().equals("L"))
                    sk.push("R");
                else
                    // [..,4,# becomes [..,4,L
                    sk.push("L");
            } else {
                if (sk.isEmpty()) {
                    if (root == null) {
                        // set the root node
                        root = tk;
                    } else {
                        // there can't be 2 roots!
                        return false;
                    }
                }
                sk.push(tk);
            }

            // Recursively resolve all series of the form [..,4,L,R
            while (sk.size() >= 3 && sk.peek().equals("R")) {
                String right = sk.pop();
                String left = sk.pop();
                String head = sk.pop();
                if (right.equals("R") && left.equals("L") && !head.equals("L") && !head.equals("R")) {
                    if (!sk.isEmpty()) {
                        if (sk.peek().equals("L")) {
                            sk.push("R");
                        } else {
                            sk.push("L");
                        }
                    }
                } else {
                    sk.push(head);
                    sk.push(left);
                    sk.push(right);
                }
            }
        }

        return sk.isEmpty();
    }

    // https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
    public boolean isValidSerializationDegrees(String preorder) {
        // diff = outdegree - indegree
        int diff = 1;
        for (StringTokenizer st = new StringTokenizer(preorder, ","); st.hasMoreTokens();) {
            String tkn = st.nextToken();
            if (--diff < 0)
                return false;
            if (!tkn.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}
