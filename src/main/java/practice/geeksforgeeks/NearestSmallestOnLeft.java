/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.geeksforgeeks;

import util.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestOnLeft {

    public void solve() throws Exception {

        //Input:  arr[] = {1, 6, 4, 10, 2, 5}
        //Output:         {_, 1, 1,  4, 1, 2}

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = IOUtils.nextInts(n);
            Stack<Integer> s = new Stack<>();
            String[] res = new String[n];

            res[0] = "_";
            s.push(arr[0]);

            for ( int i = 1; i < arr.length; ++i ) {
                while ( !s.empty() && s.peek() > arr[i] ) s.pop();
                if ( s.empty() ) {
                    res[i] = "_";
                } else {
                    res[i] = s.peek().toString();
                }
                s.push(arr[i]);
            }

            System.out.println(Arrays.toString(res));
        }
    }
}
