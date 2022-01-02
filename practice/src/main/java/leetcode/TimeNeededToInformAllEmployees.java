/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {

    private int f(int i, Map<Integer, List<Integer>> map, int[] informTime) {
        int ans = 0;
        for (int sub: map.getOrDefault(i, new ArrayList<>())) {
            ans = Math.max(ans, f(sub, map, informTime));
        }
        return ans + informTime[i];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (manager[i] == -1)
                continue;
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return f(headID, map, informTime);
    }
}
