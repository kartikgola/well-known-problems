/*
 * Author: Kartik Gola
 * Date: 10/5/21, 12:26 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class SequenceReconstruction {

    private boolean isNotValid(int x, int n) {
        return x < 1 || x > n;
    }

    // Topological ordering should exist
    // & it should be the ONLY topological ordering possible
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        if (seqs.isEmpty())
            return false;

        int[] deg = new int[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (List<Integer> seq: seqs) {
            if (seq.isEmpty() || isNotValid(seq.get(0), n))
                return false;
            for (int i = 0; i < seq.size()-1; ++i) {
                if (isNotValid(seq.get(i+1), n))
                    return false;
                deg[seq.get(i+1)]++;
                map.putIfAbsent(seq.get(i), new ArrayList<>());
                map.get(seq.get(i)).add(seq.get(i+1));
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; ++i)
            if (deg[i] == 0)
                q.add(i);

        int j = 0;
        int[] ans = new int[n];
        while (!q.isEmpty()) {
            if (q.size() > 1)
                return false;
            int u = q.poll();
            ans[j++] = u;
            for (int v: map.getOrDefault(u, new ArrayList<>())) {
                if (--deg[v] == 0) {
                    if (!q.isEmpty())
                        return false;
                    q.add(v);
                }
            }
        }

        return j == n && Arrays.equals(org, ans);
    }
}
