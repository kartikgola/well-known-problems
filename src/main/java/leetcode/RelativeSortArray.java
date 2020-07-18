/*
 * Author: Kartik Gola
 * Date: 15/07/20, 10:35 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] priorities = new int[1001];
        // Greater number -> greater priority
        int priorityValue = Integer.MAX_VALUE;
        for ( int a : arr2 )
            priorities[a] = priorityValue--;

        int[] count = new int[1001];
        for ( int a : arr1 )
            count[a]++;

        for ( int i = 0; i <= 1000; ++i ) {
            if ( count[i] > 0 && priorities[i] == 0 ) {
                priorities[i] = priorityValue--;
            }
        }

        List<Integer> al = new ArrayList<>();
        for ( int a : arr1 )
            al.add(a);

        Collections.sort(al, (Integer a, Integer b) -> {
            return priorities[b] - priorities[a];
        });

        int w = 0;
        for ( Integer a : al )
            arr1[w++] = a;

        return arr1;
    }
}
