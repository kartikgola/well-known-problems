/*
 * Author: Kartik Gola
 * Date: 6/10/21, 8:02 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/my-calendar-i/
 */

package leetcode;

import java.util.TreeMap;

public class MyCalendar1 {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar1() { }

    public boolean book(int start, int end) {
        Integer left = map.floorKey(start);
        Integer right = map.ceilingKey(start);
        if ((left == null || map.get(left) <= start) && (right == null || right >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
