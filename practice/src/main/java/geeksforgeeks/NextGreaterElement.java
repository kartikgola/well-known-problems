/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package geeksforgeeks;

import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreater(int[] arr) {
        final int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        int j = 0;
        for ( int i = 1; i < n; ++i ) {
            if ( st.empty() || arr[st.peek()] >= arr[i] ) {
                st.push(i);
            } else {
                while ( !st.empty() && arr[st.peek()] < arr[i] ) {
                    res[st.pop()] = arr[i];
                }
                st.push(i);
            }
        }

        while ( !st.empty() ) {
            res[st.pop()] = -1;
        }

        return res;
    }
}
