/*
 * Author: Kartik Gola
 * Date: 9/2/21, 11:37 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class SmallestStringWithSwaps {

    private int[] root;
    private int groups;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    private int find(int u) {
        if (root[u] < 0)
            return u;
        return root[u] = find(root[u]);
    }

    private void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu != pv) {
            if (root[pu] <= root[pv]) {
                root[pu] += root[pv];
                root[pv] = pu;
                map.get(pu).addAll(map.get(pv));
                map.remove(pv);
            } else {
                root[pv] += root[pu];
                root[pu] = pv;
                map.get(pv).addAll(map.get(pu));
                map.remove(pu);
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final int n = s.length();
        char[] ans = new char[n];
        groups = n;
        root = new int[n];
        Arrays.fill(root, -1);

        for (int i = 0; i < n; ++i) {
            List<Integer> al = new ArrayList<>();
            al.add(i);
            map.put(i, al);
        }

        for (List<Integer> pair: pairs) {
            union(pair.get(0), pair.get(1));
        }

        for (List<Integer> al: map.values()) {
            char[] temp = new char[al.size()];
            for (int i = 0; i < al.size(); ++i) {
                temp[i] = s.charAt(al.get(i));
            }
            Arrays.sort(temp);
            Collections.sort(al);
            for (int i = 0; i < al.size(); ++i) {
                ans[al.get(i)] = temp[i];
            }
        }

        return new String(ans);
    }
}
