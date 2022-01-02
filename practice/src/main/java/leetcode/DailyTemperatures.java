/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        // stack stores monotonically decreasing values(indices) from right to left
        Stack<Integer> st = new Stack<>();
        for (int i = temp.length-1; i >= 0; --i) {
            // keep popping until current value is correctly placed as per stack order
            while (!st.isEmpty() && temp[i] >= temp[st.peek()])
                st.pop();
            ans[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return ans;
    }
}
