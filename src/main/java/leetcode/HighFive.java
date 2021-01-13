/*
 * Author: Kartik Gola
 * Date: 13/01/2021, 23:08
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/high-five/
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighFive {

    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (int[] a, int[] b) -> a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);
        List<int[]> al = new ArrayList<>();
        int prev = -1, sum = 0;

        for (int i = 0; i < items.length; ++i) {
            if (prev == -1 || (items[prev][0] == items[i][0] && i - prev < 5)) {
                sum += items[i][1];
                prev = prev == -1 ? i : prev;
            } else {
                al.add(new int[]{items[prev][0], sum / 5});
                while (i < items.length - 1 && items[i][0] == items[prev][0]) ++i;
                sum = items[i][1];
                prev = i;
            }
        }

        // add to al if exact 5 count is remaining
        if (items.length - prev == 5)
            al.add(new int[]{items[prev][0], sum / 5});

        // create answer array
        int[][] ans = new int[al.size()][2];
        for (int i = 0; i < al.size(); ++i)
            ans[i] = al.get(i);

        return ans;
    }
}
