/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class CapacityToShipPackagesWithinDDays {

    private boolean canShip(int[] weights, int capacity, int days) {
        int currWeight = 0;
        int currDays = 1;
        for (int w: weights) {
            currWeight += w;
            if (currWeight > capacity) {
                currWeight = w;
                currDays++;
                if (currDays > days)
                    return false;
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        // If you are shipping with only 1 item, capacity should be at least max weight
        int l = weights[0];
        // If you are shipping all items, capacity should be sum of weights
        int r = weights[0];
        for (int w: weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {
            int m = l+(r-l)/2;
            if (canShip(weights, m, days))
                r = m;
            else
                l = m+1;
        }

        return l;
    }
}
