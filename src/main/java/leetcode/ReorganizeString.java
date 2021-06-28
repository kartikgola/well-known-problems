/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReorganizeString {

    // Using sorting + hashmap
    // Time: O(N), Space: O(N)
    public String reorganizeStringWithSorting(String S) {
        if ( S.length() <= 1 )
            return S;

        final int n = S.length();
        int[][] map = new int[26][2];
        char[] res = new char[n];

        for ( int i = 0; i < S.length(); ++i ) {
            int chi = S.charAt(i) - 'a';
            map[ chi ][0]++;
            map[ chi ][1] = chi;
            if ( map[ chi ][0] > ((n + 1) / 2) )
                return "";
        }

        Arrays.sort(map, (int[] a, int[] b) -> { return a[0] - b[0]; });

        int i = 1;
        for ( int[] item : map ) {
            while ( item[0]-- > 0 ) {
                res[i] = (char) (item[1] + 'a');
                i += 2;
                if ( i >= n ) {
                    i = 0;
                }
            }
        }

        return new String(res);
    }

    static class CharOccurance {
        int occurance;
        char ch;

        CharOccurance(int ct, char ch) {
            occurance = ct;
            this.ch = ch;
        }
    }

    // Using greedy(using PQ) + hashmap
    // Time: O(N), Space: O(N)
    public String reorganizeStringWithGreedy(String S) {
        int N = S.length();
        int[] count = new int[26];
        PriorityQueue<CharOccurance> pq = new PriorityQueue<>((a, b) ->
                a.occurance == b.occurance ? a.ch - b.ch : b.occurance - a.occurance);

        for (char c: S.toCharArray())
            count[c - 'a']++;

        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) return "";
                pq.add(new CharOccurance(count[i], (char) ('a' + i)));
            }
        }

        StringBuilder res = new StringBuilder();
        while (pq.size() >= 2) {
            // Get the first 2 most frequent characters
            CharOccurance p1 = pq.poll();
            CharOccurance p2 = pq.poll();

            res.append(p1.ch);
            res.append(p2.ch);

            // Add the characters back, if their count is > 0
            if (--p1.occurance > 0)
                pq.add(p1);

            if (--p2.occurance > 0)
                pq.add(p2);
        }

        if (pq.size() > 0)
            res.append(pq.poll().ch);

        return res.toString();
    }

}

