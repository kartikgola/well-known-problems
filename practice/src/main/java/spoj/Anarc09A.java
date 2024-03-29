/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Anarc09A {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Stack<Character> stack = new Stack<>();
        int t = 1;

        while ( !input.contains("-") ) {

            for ( Character ch : input.toCharArray() ) {
                if ( ch == '{' ) {
                    stack.push(ch);
                } else {
                    if ( !stack.empty() && stack.peek() == '{' ) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }

            int operations = 0;
            while ( !stack.empty() ) {
                Character top = stack.pop();
                if ( top == '{' ) {
                    // Case of {{
                    if ( stack.peek() == '{' ) {
                        stack.pop();
                        operations++;
                    } else {
                        // Case of }{
                        stack.pop();
                        operations += 2;
                    }
                } else {
                    // Case of }}
                    stack.pop();
                    operations++;
                }
            }

            System.out.println(t++ + ". " + operations);
            input = reader.readLine();
        }
    }
}
