/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class ReconstructItinerary {

    private void dfs(String from, Map<String, Queue<String>> map, List<String> res) {
        Queue<String> pq = map.getOrDefault(from, new PriorityQueue<>());
        if (pq.isEmpty()) {
            res.add(from);
            return;
        }
        while (!pq.isEmpty()) {
            String to = pq.poll();
            dfs(to, map, res);
        }
        res.add( from );
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for ( List<String> tkt : tickets ) {
            String from = tkt.get(0);
            String to = tkt.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }

        List<String> res = new ArrayList<>();
        dfs( "JFK", map, res );

        Collections.reverse(res);
        return res;
    }
}
