/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
                // Elements that we currently have, i.e., p == n-k
                return p;
            else if ( p > k )
                // We need more elements than we currently have
                return quickSelect(nums, lo, p - 1, k);
            else
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
        // Think of it in this way - If you want top 1 element, then you will have to look at the entire array
        // that means, the quickselect partition must be at n-1, ensuring that all arr[0...n-1] have frequency <= freq[arr[n-1]]
        int p = quickSelect(uniques, 0, uniques.length - 1, uniques.length - k);
        int[] res = new int[uniques.length - p];

        System.arraycopy(uniques, p, res, 0, res.length);
        return res;
    }
}
