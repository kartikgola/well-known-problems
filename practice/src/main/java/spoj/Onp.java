/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Onp {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            String input = reader.readLine();
            Stack<String> stack = new Stack<>();
            StringBuilder builder = new StringBuilder();

            final String operators = "+-*/^";
            for ( int i = 0; i < input.length(); ++i ) {
                String ch = input.charAt(i) + "";
                if ( ch.equals("(") || operators.contains(ch) ) {
                    stack.push(ch);
                } else if ( ch.matches("^[a-z]$") ) {
                    builder.append(ch);
                } else {
                    while ( !stack.peek().equals("(") ) {
                        builder.append(stack.pop());
                    }
                    stack.pop();
                }
            }

            System.out.println(builder);
        }
    }
}
