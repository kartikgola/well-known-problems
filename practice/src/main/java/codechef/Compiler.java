/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Compiler {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            String input = reader.readLine();
            Stack<Character> stack = new Stack<>();

            int prefixLen = 0;
            int runningLen = 0;
            for ( Character ch : input.toCharArray() ) {
                if ( ch == '<' ) {
                    stack.push(ch);
                } else {
                    if ( stack.empty() )
                        break;
                    else {
                        stack.pop();
                        runningLen += 2;
                        if ( stack.empty() ) {
                            prefixLen += runningLen;
                            runningLen = 0;
                        }
                    }
                }
            }

            System.out.println(prefixLen);
        }
    }
}
