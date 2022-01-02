/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenDigits {

    private List<List<Integer>> permute(int[] A, boolean[] vis) {
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < A.length; ++i ) {
            if ( !vis[i] ) {
                vis[i] = true;
                List<List<Integer>> sub = permute(A, vis);
                if ( sub.isEmpty() ) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(A[i]);
                    res.add(temp);
                } else {
                    for ( List<Integer> l : sub ) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(A[i]);
                        temp.addAll(l);
                        res.add(temp);
                    }
                }
                vis[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(List<Integer> time) {
        int hr = 10 * time.get(0) + time.get(1);
        int min = 10 * time.get(2) + time.get(3);
        return hr >= 0 && hr <= 23 && min >= 0 && min <= 59;
    }

    private int compare(List<Integer> t1, List<Integer> t2) {
        int hr1 = 10 * t1.get(0) + t1.get(1);
        int min1 = 10 * t1.get(2) + t1.get(3);
        int hr2 = 10 * t2.get(0) + t2.get(1);
        int min2 = 10 * t2.get(2) + t2.get(3);
        final int hdiff = hr1 - hr2;
        final int mdiff = min1 - min2;
        return hdiff != 0 ? hdiff : mdiff;
    }

    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> perms = permute(A, new boolean[A.length]);
        List<Integer> max = null;
        for ( List<Integer> p : perms ) {
            if ( isValid(p) ) {
                if ( max == null || compare(max, p) < 0 ) {
                    max = p;
                }
            }
        }
        return max == null ? "" : "" + max.get(0) + max.get(1) + ":" + max.get(2) + max.get(3);
    }
}
