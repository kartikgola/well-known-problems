/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;
import java.util.StringTokenizer;

public class LongestAbsoluteFilePath {

    private boolean isFile(String s) {
        return s.contains(".");
    }

    public int lengthLongestPath(String input) {
        int ans = 0;
        StringTokenizer st = new StringTokenizer(input, "\n");
        Stack<String> stack = new Stack<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            String strippedToken = token.trim();
            int depth = token.length() - strippedToken.length();

            // While stack size is less than depth, we keep popping
            // because current token is not part of stack.peek()
            while (!stack.isEmpty() && stack.size() > depth)
                stack.pop();

            if (stack.isEmpty())
                stack.push(strippedToken);
            else
                stack.push(stack.peek() + "/" + strippedToken);

            // We only need answer in case of files
            if (isFile(stack.peek()))
                ans = Math.max(ans, stack.peek().length());
        }

        return ans;
    }
}
