/*
 * Author: Kartik Gola
 * Date: 9/1/21, 10:39 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            a[i] = arr[i];

        Arrays.sort(a, Comparator.comparingInt(Math::abs));

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: a)
            map.put(num, map.getOrDefault(num,0) + 1);


        for (int i = 0; i < a.length; ++i) {
            if (map.getOrDefault(a[i], 0) > 0) {
                if (map.getOrDefault(a[i]*2, 0) > 0) {
                    map.put(a[i], map.get(a[i])-1);
                    map.put(a[i]*2, map.get(a[i]*2)-1);
                } else return false;
            }
        }

        return true;
    }
}
