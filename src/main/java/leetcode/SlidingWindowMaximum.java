/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:00 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/sliding-window-maximum/
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        if ( k < 1 || n < 1 )
            return new int[]{};

        int w = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        for ( int i = 0; i < n; ++i ) {
            // Remove any out-of-window index (if present)
            if ( !deq.isEmpty() && i - deq.peekFirst() >= k )
                deq.removeFirst();
            // Remove all the nums[indices] which are lesser than nums[i] in current window
            while ( !deq.isEmpty() && nums[i] > nums[deq.peekLast()] )
                deq.removeLast();
            deq.addLast(i);
            if ( i >= k - 1 ) // Example, for, k = 3, only start adding answer from index 2 onwards
                ans[w++] = nums[deq.peekFirst()];
        }

        return ans;
    }
}
