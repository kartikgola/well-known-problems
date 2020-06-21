/*
 * Author: Kartik Gola
 * Date: 20/06/20, 11:45 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToConnectSticks {

    public int minimumCost(int[] sticks) {
        final int n = sticks.length;
        if ( n == 0 )
            return 0;

        int cost = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for ( int st : sticks )
            pq.add(st);

        while ( pq.size() >= 2 ) {
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        };

        if ( pq.size() > 0 )
            cost += pq.poll();

        return cost;
    }
}
