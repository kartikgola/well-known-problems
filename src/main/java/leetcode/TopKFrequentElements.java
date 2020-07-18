/*
 * Author: Kartik Gola
 * Date: 7/18/20 12:27 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TopKFrequentElements {

    Map<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int lo, int hi, int randomPart) {
        int pvtElem = nums[randomPart];
        swap(nums, randomPart, hi);
        int i = lo;
        for ( int j = lo; j <= hi; ++j ) {
            if ( map.get(nums[j]) < map.get(pvtElem) ) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        if ( lo >= hi )
            return lo;
        else {
            int randomPart = lo + rand.nextInt(hi - lo);
            int p = partition(nums, lo, hi, randomPart);
            if ( p == k )
                // Elements that we currently have, i.e., 'uniques.length - p' == top k elements
                return p;
            else if ( p > k )
                // 'uniques.length - p' is less than elements you want in answer. So, we get more from left!
                // Example, if uniques.length = 3, k = 3, p = 1
                // Here, we have already got top 3 - 1 => 2 elements, but since k = 3, we need more, so we go leftwards.
                return quickSelect(nums, lo, p - 1, k);
            else
                // If we need less 'top' elements than we currently have, we go rightwards.
                return quickSelect(nums, p + 1, hi, k);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        for ( int num : nums )
            map.put(num, map.getOrDefault(num, 0) + 1);

        int[] uniques = new int[map.size()];
        int w = 0;
        for ( Integer key : map.keySet() )
            uniques[w++] = key;

        // Roughly sort the array to quick-select an index, such that elements ahead of that index
        // have frequency equal to higher than the selected element.
        int p = quickSelect(uniques, 0, uniques.length - 1, uniques.length - k);
        int[] res = new int[uniques.length - p];

        System.arraycopy(uniques, p, res, 0, res.length);
        return res;
    }
}
