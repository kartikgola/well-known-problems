/*
 * Author: Kartik Gola
 * Date: 6/2/21, 1:17 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/design-hit-counter/
 */

package leetcode;

import java.util.TreeMap;

public class DesignHitCounter {

    private final int THRESHOLD = 5 * 60;
    private final TreeMap<Integer, Integer> map = new TreeMap<>();
    private int hits = 0;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        map.put(0, 0);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, ++hits);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        final int last = Math.max(timestamp - THRESHOLD, 0);
        return hits - map.floorEntry(last).getValue();
    }
}
