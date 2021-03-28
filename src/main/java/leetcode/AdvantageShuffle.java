/*
 * Author: Kartik Gola
 * Date: 28/03/2021, 23:19
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a: A)
            map.put(a, map.getOrDefault(a, 0) + 1);

        int j = 0;
        for (int b: B) {
            // Find out the entry just greater than 'b'
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(b + 1);
            if (entry == null)
                entry = map.firstEntry();
            A[j++] = entry.getKey();
            if (entry.getValue() == 1)
                map.remove(entry.getKey());
            else
                map.put(entry.getKey(), entry.getValue() - 1);
        }

        return A;
    }
}
