/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stpar {

    private int[] getArrayInput(final BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while ( n != 0 ) {
            int[] A = this.getArrayInput(reader, n);
            Stack<Integer> aux = new Stack<>();
            Stack<Integer> seq = new Stack<>();

            for ( int num : A ) {
                int top = seq.empty() ? 0 : seq.peek();
                if (top == num - 1) {
                    seq.push(num);
                    while ( !aux.empty() && aux.peek() == seq.peek() + 1 ) {
                        seq.push(aux.pop());
                    }
                } else {
                    aux.push(num);
                }
            }

            if ( aux.empty() )
                System.out.println("yes");
            else
                System.out.println("no");

            n = Integer.parseInt(reader.readLine());
        }
    }
}
