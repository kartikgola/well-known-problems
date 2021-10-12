/*
 * Author: Kartik Gola
 * Date: 10/11/21, 11:48 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

    public int oddEvenJumps(int[] A) {
        int n = A.length;
        int ans = 1;

        // At odd jump, can we reach some ceil(A[i]) from A[i] & eventually A[n-1]
        boolean[] higher = new boolean[n];
        // At even jump, can we reach some floor(A[i]) from A[i] & eventually A[n-1]
        boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>() {{ put(A[n-1], n-1); }};

        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> floor = map.floorEntry(A[i]);

            if (ceil != null)
                higher[i] = lower[ceil.getValue()];

            if (floor != null)
                lower[i] = higher[floor.getValue()];

            if (higher[i])
                ans++;

            map.put(A[i], i);
        }

        return ans;
    }
}
