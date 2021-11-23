/*
 * Author: Kartik Gola
 * Date: 11/23/21, 10:03 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueNumber {

    private final Set<Integer> linkedSet = new LinkedHashSet<>();
    private final Map<Integer, Boolean> unique = new HashMap<>();

    public FirstUniqueNumber(int[] nums) {
        for (int num: nums)
            add(num);
    }

    public int showFirstUnique() {
        return linkedSet.isEmpty() ? -1 : linkedSet.iterator().next();
    }

    public void add(int value) {
        if (!unique.containsKey(value)) {
            unique.put(value, true);
            linkedSet.add(value);
        } else if (unique.get(value)) {
            unique.put(value, false);
            linkedSet.remove(value);
        }
    }
}
