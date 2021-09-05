/*
 * Author: Kartik Gola
 * Date: 9/5/21, 11:43 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class SumOfDistancesInTree {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] count;
    int[] ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for (int i = 0; i < edges.length; ++i) {
            map.putIfAbsent(edges[i][0], new HashSet<>());
            map.putIfAbsent(edges[i][1], new HashSet<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        this.n = n;
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        f(0, -1);
        g(0, -1);
        return ans;
    }

    private void f(int x, int p) {
        for (int y: map.getOrDefault(x, new HashSet<>())) {
            if (y != p) {
                f(y, x);
                count[x] += count[y];
                ans[x] += ans[y] + count[y];
            }
        }
    }

    private void g(int x, int p) {
        for (int y: map.getOrDefault(x, new HashSet<>())) {
            if (y != p) {
                ans[y] = ans[x] - count[y] + n - count[y];
                g(y, x);
            }
        }
    }
}
