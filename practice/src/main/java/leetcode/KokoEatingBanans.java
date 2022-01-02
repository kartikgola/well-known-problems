/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class KokoEatingBanans {

    private long sum(int[] piles, int k) {
        long time = 0;
        for (int i = 0; i < piles.length; ++i) {
            time += piles[i] / k;
            time += piles[i] % k > 0 ? 1 : 0;
        }
        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p: piles)
            max = Math.max(max, p);

        int l = 1, r = max;
        while (l < r) {
            int k = l+(r-l)/2;
            long time = sum(piles, k);
            // going too fast, can try to decrease k
            if (time <= h) {
                r = k-1; // 1,5 => 3 => 10hrs => 4,5
            } else {
                /// going too slow, can try to increase k
                l = k+1;
            }
        }

        return sum(piles, l) > h ? l+1 : l;
    }
}
