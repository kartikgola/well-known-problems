/*
 * Author: Kartik Gola
 * Date: 12/21/21, 7:50 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuccessfulTrade {

    private static boolean canTrade(int[][] bankHours, int a, int b) {
        Arrays.sort(bankHours, (b1, b2) -> b1[0] - b2[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[]{bankHours[0][0], bankHours[0][1]});

        // merge the contiguous intervals so that list<int[]> contains only non-overlapping intervals
        for (int i = 1; i < bankHours.length; ++i) {
            int[] last = mergedIntervals.get(mergedIntervals.size()-1);
            int[] curr = bankHours[i];
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                mergedIntervals.add(curr);
            }
        }

        // if trade (a, b) is present in any of the interval, it can be completed; otherwise, not
        for (int[] intv: mergedIntervals) {
            if (intv[0] >= a && b <= intv[1])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] bankHours = new int[][]{{2, 7}, {9, 16}, {11, 17}, {14, 20}};
        System.out.println(canTrade(bankHours, 2, 10));
        System.out.println(canTrade(bankHours, 10, 17));
        System.out.println(canTrade(bankHours, 15, 21));
    }
}
