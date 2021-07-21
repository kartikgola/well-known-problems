/*
 * Author: Kartik Gola
 * Date: 2/6/21, 6:17 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/simplify-path/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimplifyPath {

    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        Stack<String> s = new Stack<>();
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (!t.isEmpty() && !t.equals(".")) {
                if (t.equals("..")) {
                    if (!s.isEmpty())
                        s.pop();
                } else {
                    s.push(t);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String val: new ArrayList<>(s))
            sb.append("/").append(val);

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
