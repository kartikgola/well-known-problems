/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; ++i) {
            map[i] = new ArrayList<>();
        }
        for (int[] e: edges) {
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> v = new HashSet<>();

        while (!q.isEmpty()) {
            int c = q.poll();
            if (v.contains(c))
                continue;
            if (c == end)
                return true;
            v.add(c);
            for (int d: map[c])
                q.add(d);
        }

        return false;
    }
}
