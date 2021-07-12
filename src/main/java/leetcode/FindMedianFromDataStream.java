/*
 * Author: Kartik Gola
 * Date: 7/12/21, 9:57 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-median-from-data-stream/
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    // Max-heap that stores numbers less than median
    private Queue<Integer> lows = new PriorityQueue<>((a, b) -> b - a);

    // Min-heap that stores numbers greater than equal to median
    private Queue<Integer> highs = new PriorityQueue<>();

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
    }

    public void addNum(int num) {
        highs.add(num);
        lows.add(highs.poll());
        if (lows.size() > highs.size())
            highs.add(lows.poll());
    }

    public double findMedian() {
        return highs.size() > lows.size() ? highs.peek() : (highs.peek() + lows.peek()) / 2.0;
    }
}
