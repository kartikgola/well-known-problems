/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar1 {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar1() { }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> before = map.floorEntry(start);
        Map.Entry<Integer, Integer> after = map.ceilingEntry(start);
        boolean ok = true;
        if (before != null && before.getValue() > start)
            ok = false;
        if (after != null && after.getKey() < end)
            ok = false;
        if (!ok)
            return false;
        map.put(start, end);
        return true;
    }
}
