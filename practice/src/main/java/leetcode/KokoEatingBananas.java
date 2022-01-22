/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class KokoEatingBananas {

    private boolean canEat(int[] piles, int k, int h) {
        int time = 0;
        for (int p: piles) {
            time += (int) Math.ceil(p / (k * 1.0));
        }
        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().orElse(0);

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, mid, h))
                high = mid;
            else
                low = mid+1;
        }

        return canEat(piles, low, h) ? low : low+1;
    }
}
