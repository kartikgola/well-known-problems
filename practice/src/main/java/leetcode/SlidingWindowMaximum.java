/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
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
                ans[i-k+1] = nums[deq.peekFirst()];
        }

        return ans;
    }
}
