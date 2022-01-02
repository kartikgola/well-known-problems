/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; ++i) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        int ans = 0;
        double prev = 0;

        for (Map.Entry<Integer, Double> e: map.entrySet()) {
            int pos = e.getKey();
            double time = e.getValue();

            if (time > prev) {
                ans++;
                prev = time;
            }
        }

        return ans;
    }
}
