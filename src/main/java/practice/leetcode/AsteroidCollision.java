/*
 * Author: Kartik Gola
 * Date: 9/15/21, 11:08 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        outer:
        for (int a: asteroids) {
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() > -1*a) {
                    continue outer;
                } else if (st.peek() == -1*a) {
                    st.pop();
                    continue outer;
                } else {
                    st.pop();
                }
            }
            st.push(a);
        }

        int w = st.size()-1;
        int[] ans = new int[st.size()];
        while (!st.isEmpty())
            ans[w--] = st.pop();

        return ans;
    }
}
