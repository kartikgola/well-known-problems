/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinNoOfRefuelingStops {

    /*
    * When driving past a gas station, let's remember the amount of fuel it contained. We don't need to decide yet whether to fuel up here or not - for example, there could be a bigger gas station up ahead that we would rather refuel at.
    * When we run out of fuel before reaching the next station, we'll retroactively fuel up: greedily choosing the largest gas stations first.
    * This is guaranteed to succeed because we drive the largest distance possible before each refueling stop, and therefore have the largest choice of gas stations to (retroactively) stop at.
    * */
    public int minRefuelStops(int target, int tank, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        int ans = 0;
        int prev = 0;
        for (int[] st: stations) {
            int loc = st[0];
            int fuel = st[1];
            tank -= (loc - prev);

            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }

            if (tank < 0)
                return -1;

            pq.add(fuel);
            prev = loc;
        }

        tank -= (target - prev);
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }

        return tank < 0 ? -1 : ans;
    }
}
