/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] nums) {
        final int n = nums.length;
        int ans = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; ++i) {
            int l = i-1;
            while (l >= 0 && nums[l] >= nums[i]) {
                l = left[l]-1;
            }
            left[i] = l+1;
        }

        right[n-1] = n-1;
        for (int i = n-2; i >= 0; --i) {
            int j = i+1;
            while (j < n && nums[i] <= nums[j]) {
                j = right[j]+1;
            }
            right[i] = j-1;
        }

        for (int j = 0; j < n; ++j) {
            ans = Math.max((right[j]-left[j]+1)*nums[j], ans);
        }

        return ans;
    }

    public int largestRectangleArea2(int[] heights) {
        final int n = heights.length;
        int ans = 0;

        // Keep a monotonically increasing stack of height indices
        // such that height[stack.peek()] < height[i]
        // so, whenever we get a value which is less than equal to stack top, we can be sure to pop() and calc a candidate answer
        // because heights[stack.peek()] >= height[i], and so a rectangle formed using height[i] will always be limited to a height of height[i]
        // so, all the indices in stack which have height >= height[i] are popped and their width is calculated as i-stack.peek()-1
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // calculate a candidate answer using popped element's height
                int pop = stack.pop();
                int height = heights[pop];
                int width = i - stack.peek() - 1;
                ans = Math.max(ans, height*width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int pop = stack.pop();
            int height = heights[pop];
            // right wall is 'n' because it represents greater height
            // left wall is peek index because it represents lesser height
            int width = n - stack.peek() - 1;
            ans = Math.max(ans, height*width);
        }

        return ans;
    }
}
