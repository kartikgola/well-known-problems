/*
 * Author: Kartik Gola
 * Date: 19/06/20, 7:41 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class OptimalUtilization {

    public List<List<Integer>> optimalUtilization(int[][] a, int[][] b, int target) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<>();

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < b.length; j++ ) {
                int sum = a[i][1] + b[j][1];
                if ( sum <= target ) {
                    List<List<Integer>> list = tree.computeIfAbsent(sum, (k) -> new ArrayList<>());
                    list.add(Arrays.asList(a[i][0], b[j][0]));
                }
            }
        }

        return tree.floorEntry(target).getValue();
    }
}
