/*
 * Author: Kartik Gola
 * Date: 01/07/20, 3:30 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

    private boolean isOverlap(int[] a, int[] b) {
        if ( a[0] >= b[1] )
            return false;
        if ( a[1] <= b[0] )
            return false;
        return true;
    }

    public int minMeetingRooms(int[][] intervals) {
        final int n = intervals.length;
        if ( n == 0 )
            return 0;
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>();

        for ( int i = 0; i < n; ++i ) {
            // Check if any meeting room is available or not
            if ( !pq.isEmpty() && pq.peek() <= intervals[i][0] )
                pq.poll();
            // Add a new meeting room
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
