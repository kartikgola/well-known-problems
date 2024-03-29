/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class ReorderedPowerOf2 {

    private int[] getNumberMap(int num) {
        int[] map = new int[10];
        while (num > 0) {
            map[num % 10]++;
            num /= 10;
        }
        return map;
    }

    public boolean reorderedPowerOf2(int N) {
        if (N == 1)
            return true;

        int[] nMap = getNumberMap(N);
        int num = 2;
        while (num > 0) {
            if (Arrays.equals(nMap, getNumberMap(num)))
                return true;
            num <<= 1;
        }

        return false;
    }
}
