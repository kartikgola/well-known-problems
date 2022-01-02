/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class HISTOGRA {

    private ArrayList<Long> readArrayList(BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        ArrayList<Long> arrayList = new ArrayList<>();
        while ( tokenizer.hasMoreTokens() ) {
            arrayList.add(Long.parseLong(tokenizer.nextToken()));
        }
        return arrayList;
    }

    private long largestRectangleArea(List<Long> h) {
        final long n = h.size();
        if ( n == 0 ) return 0;
        if ( n == 1 ) return h.get(0);

        long max = 0;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for ( int i = 1; i < n; ++i ) {
            if ( s.empty() || h.get(s.peek()) <= h.get(i) ) {
                s.push(i);
            } else {
                while ( !s.empty() && h.get(s.peek()) > h.get(i) ) {
                    long ht = h.get(s.pop());

                    long r = i;
                    long l = s.empty() ? -1 : s.peek();

                    long wd = r - l - 1;

                    max = Math.max(max, (ht * wd));
                }
                s.push(i);
            }
        }

        while ( !s.empty() ) {
            long ht = h.get(s.pop());

            long r = n;
            long l = s.empty() ? -1 : s.peek();

            long wd = r - l - 1;

            max = Math.max(max, (ht * wd));
        }

        return max;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> list;
        while ( true ) {
            list = readArrayList(reader);
            if ( list.size() == 1 && list.get(0) == 0 ) break;
            else System.out.println(largestRectangleArea(list));
        }
    }

}
