/*
 * Author: Kartik Gola
 * Date: 6/27/21, 11:11 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package practice.leetcode;

public class Candy {

    private int sum(int n) {
        return n*(n+1)/2;
    }

    public int candy(int[] ratings) {
        final int n = ratings.length;
        int ans = 0;
        int i = 0;
        int end = 0;

        while (i < n) {
            int k = i;
            while (i+1 < n && ratings[i+1] == ratings[i])
                ++i;
            // add candies given to equal ratings
            if (i-k+1 > 2) {
                ans += (i-k+1) - 2;
//                ans += end;
            }
            int j = i;
            if (i+1 < n) {
                // decreasing slope
                if (ratings[i+1] < ratings[i]) {
                    while (i+1 < n && ratings[i+1] < ratings[i])
                        ++i;
                    ans += sum(i-j+1) - end;
                    end = 1;
                } else {
                    // increasing slope
                    while (i+1 < n && ratings[i+1] > ratings[i])
                        ++i;
                    ans += sum(i-j+1) - end;
                    end = i-j+1;
                }
            } else {
                if (ratings[i] == ratings[i-1])
                    ans += 1;
                break;
//                else
//                    ans += end;
            }
            if (k == i)
                i++;
        }

        return ans;
    }
}
