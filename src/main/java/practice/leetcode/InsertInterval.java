/*
 * Author: Kartik Gola
 * Date: 11/27/21, 12:15 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] A, int[] B) {
        List<int[]> al = new ArrayList<>();
        Collections.addAll(al, A);

        // insert B wherever A[i].start >= B.start
        int i = 0;
        while (i < A.length && A[i][0] < B[0])
            i++;
        al.add(i, B);

        List<int[]> temp = new ArrayList<>();
        temp.add(al.get(0));

        // do "merge-intervals" now
        for (int j = 1; j < al.size(); ++j) {
            int[] last = temp.get(temp.size()-1);
            if (last[1] >= al.get(j)[0]) {
                last[1] = Math.max(last[1], al.get(j)[1]);
            } else {
                temp.add(al.get(j));
            }
        }

        return temp.toArray(new int[temp.size()][2]);
    }
}
