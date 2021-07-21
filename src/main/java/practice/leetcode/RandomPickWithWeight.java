/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    int[] map;
    int sum = 0;
    Random rand = new Random();

    public RandomPickWithWeight(int[] w) {
        map = new int[w.length];
        for ( int i = 0; i < w.length; ++i ) {
            map[i] = sum;
            sum += w[i];
        }
    }

    public int pickIndex() {
        int randKey = rand.nextInt(sum);
        int idx = Arrays.binarySearch(map, randKey);
        if ( idx < 0 ) {
            idx += 2; // Get the index, just before insertion index
            idx *= -1;
        }
        return idx;
    }
}
