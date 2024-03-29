/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
