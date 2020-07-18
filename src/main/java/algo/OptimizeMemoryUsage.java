/*
 * Author: Kartik Gola
 * Date: 11/07/20, 8:21 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OptimizeMemoryUsage {

    private static List<List<Integer>> optimize(List<Integer> ft,
                                         List<Integer> bt,
                                         int k) {
        List<List<Integer>> res = new ArrayList<>();
        if ( k == 0 ) return res;
        Collections.sort(ft, (Integer a, Integer b) -> Integer.compare(b, a));
        Collections.sort(bt);

        // 7,6,5,4,2,1
        // 3,2,1
        // 6

        int i = 0, j = 0;
        while ( i < ft.size() && j < bt.size() ) {
            if ( ft.get(i) + bt.get(j) == k ) {
                res.add(Arrays.asList(ft.get(i++), bt.get(j++)));
            } else if ( ft.get(i) == k || bt.get(j) == k ) {
                if ( ft.get(i) == k )
                    res.add(Arrays.asList(ft.get(i++), -1));
                if ( bt.get(j) == k )
                    res.add(Arrays.asList(bt.get(j++), -1));
            } else if ( ft.get(i) + bt.get(j) > k ) {
                ++i;
            } else {
                ++j;
            }
        }

        while ( i < ft.size() ) {
            if ( ft.get(i) == k ) {
                res.add(Arrays.asList(k, -1));
            } else break;
            ++i;
        }

        while ( j < bt.size() ) {
            if ( bt.get(j) == k ) {
                res.add(Arrays.asList(k, -1));
            } else if ( bt.get(j) > k ) break;
            ++j;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer fts = new StringTokenizer(rdr.readLine(), ",");
        List<Integer> ft = new ArrayList<>();
        while ( fts.hasMoreTokens() )
            ft.add(Integer.parseInt(fts.nextToken()));

        StringTokenizer bts = new StringTokenizer(rdr.readLine(), ",");
        List<Integer> bt = new ArrayList<>();
        while ( bts.hasMoreTokens() )
            bt.add(Integer.parseInt(bts.nextToken()));

        int k = Integer.parseInt(rdr.readLine());

        System.out.println(optimize(ft, bt, k));
    }
}
