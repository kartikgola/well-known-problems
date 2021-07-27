/*
 * Author: Kartik Gola
 * Date: 7/27/21, 10:13 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 */

package practice.leetcode;

import java.util.*;

public class NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] ht) {
        int[] ans = new int[ht.length];
        // Monotonically decreasing stack of indices (by height)
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ht.length; i++) {
            // Smaller persons can definitely see this taller ht[i]
            while (!st.isEmpty() && ht[st.peek()] < ht[i]) {
                ans[st.pop()]++;
            }
            // In mono stack, increase count of top-most index since it can definitely see ht[i]
            if (!st.isEmpty()) {
                ans[st.peek()]++;
            }
            st.add(i);
        }

        return ans;
    }
}
