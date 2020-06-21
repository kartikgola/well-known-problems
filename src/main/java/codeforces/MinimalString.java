/*
 * Author: Kartik Gola
 * Date: 18/06/20, 9:57 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimalString {

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> t = new Stack<>();
        Stack<Character> u = new Stack<>();
        t.push(s.charAt(0));
        int i = 1;
        for ( ; i < s.length() - 1; ++i ) {
            char ch = s.charAt(i);
            if ( u.empty() && s.charAt(i + 1) < ch ) {
                t.push(ch);
            } else {
                u.push(ch);
            }
        }
        t.push(s.charAt(i));

        while ( !t.empty() )
            u.add(t.pop());

        System.out.println(u);
    }
}
