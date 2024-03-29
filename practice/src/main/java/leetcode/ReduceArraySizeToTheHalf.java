/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(map.entrySet());
        int ans = 0;
        for (int len = arr.length; len > arr.length/2; ) {
            len -= pq.poll().getValue();
            ans += 1;
        }
        return ans;
    }
}
