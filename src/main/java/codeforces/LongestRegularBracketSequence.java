/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LongestRegularBracketSequence {

    private int reduceStack(Stack<String> st, int initialSum) {
        int sum = initialSum;
        while ( !st.empty() && !st.peek().equals("(") && !st.peek().equals(")") )
            sum += Integer.parseInt(st.pop());
        return sum;
    }

    private int[] getLongest(String s) {
        Stack<String> st = new Stack<>();
        int max = 0;
        int maxCount = 0;

        for ( int i = 0; i < s.length(); ++i ) {
            if ( s.charAt(i) == '(' ) {
                st.push("(");
            } else if ( !st.empty() ) {
                if ( st.peek().equals("(") ) {
                    st.pop();
                    st.push(Integer.toString(reduceStack(st, 2)));
                } else if ( st.peek().equals(")") ) {
                    st.push(")");
                } else {
                    int sum = reduceStack(st, Integer.parseInt(st.pop()));
                    if ( !st.empty() && st.peek().equals("(") ) {
                        st.pop();
                        st.push(Integer.toString(reduceStack(st, sum + 2)));
                    } else {
                        st.push(Integer.toString(sum));
                        st.push(")");
                    }
                }
            } else {
                st.push(")");
            }
        }

        while ( !st.empty() ) {
            if ( !st.peek().equals("(") && !st.peek().equals(")") ) {
                if ( Integer.parseInt(st.peek()) > max ) {
                    max = Integer.parseInt(st.peek());
                    maxCount = 1;
                } else if ( Integer.parseInt(st.peek()) == max ) {
                    maxCount++;
                }
            }
            st.pop();
        }

        return new int[]{max, maxCount == 0 ? 1 : maxCount};
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        while ( !s.isEmpty() ) {
            int[] p = getLongest(s);
            System.out.println(p[0] + " " + p[1]);
            s = reader.readLine();
        }
    }
}
