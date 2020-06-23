/*
 * Author: Kartik Gola
 * Date: 21/06/20, 7:47 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        final int n = height.length;
        if ( n == 0 ) return 0;

        Stack<Integer> st = new Stack<>();
        int water = 0;

        for ( int i = 0; i < n; ++i ) {
            if ( st.empty() || height[st.peek()] >= height[i] ) {
                st.push(i);
            } else {
                while ( !st.empty() && height[st.peek()] < height[i] ) {
                    int t = st.pop();
                    if ( st.empty() )
                        break;

                    // Width starts from element before popped element
                    int w = i - st.peek() - 1;

                    // It is guaranteed that height[st.peek()] will be >= height[t]
                    // So, we take minimum of curr height & height[st.peek()]
                    // Also, we reduce it by height[t] as that height denotes
                    // the height above 0-level that we have crossed.
                    int h = Math.min(height[i], height[st.peek()]) - height[t];

                    water += w * h;
                }
                st.push(i);
            }
        }

        return water;
    }

    public int trapBruteForce(int[] height) {
        final int n = height.length;
        if ( n == 0 ) return 0;
        int water = 0;

        for ( int i = 0; i < n; ++i ) {
            int left = 0, right = 0;
            for ( int j = i - 1; j > -1; --j ) {
                left = Math.max(left, height[j]);
            }
            for ( int j = i + 1; j < n; ++j ) {
                right = Math.max(right, height[j]);
            }
            water += Math.min(left, right) - height[i];
        }

        return water;
    }
}
