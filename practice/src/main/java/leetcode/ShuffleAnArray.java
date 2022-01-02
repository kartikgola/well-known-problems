/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {

    private int[] orig;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        orig = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orig;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (orig.length <= 1)
            return orig;

        int[] perm = new int[orig.length];
        List<Integer> aux = new ArrayList<>(orig.length);
        for ( int num : orig ) aux.add(num);

        for ( int i = 0; i < perm.length; ++i ) {
            int pivot = random.nextInt(aux.size());
            perm[i] = aux.get(pivot);
            aux.remove(pivot);
        }

        return perm;
    }

    private void swapNums(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] fisherYatesShuffle() {
        int[] perm = orig.clone();
        for ( int i = 0; i < perm.length; ++i ) {
            swapNums(perm, i, random.nextInt(perm.length - i) + i);
        }
        return perm;
    }
}
