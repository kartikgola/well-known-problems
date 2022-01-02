/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class AccountsMerge {

    private Map<String, Set<String>> edges = new HashMap<>();
    private Map<String, String> map = new HashMap<>();

    private String name = null;
    private void dfs(String from, Set<String> vis, List<String> al) {
        if (vis.contains(from))
            return;
        vis.add(from);
        al.add(from);
        if (map.containsKey(from))
            name = map.get(from);
        for (String to: edges.getOrDefault(from, new HashSet<>())) {
            dfs(to, vis, al);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> al: accounts) {
            String name = al.get(0);
            map.put(al.get(1), name);
            edges.putIfAbsent(al.get(1), new HashSet<>());

            for (int i = 1; i+1 < al.size(); ++i) {
                String from = al.get(i);
                String to = al.get(i+1);
                edges.putIfAbsent(from, new HashSet<>());
                edges.putIfAbsent(to, new HashSet<>());
                edges.get(from).add(to);
                edges.get(to).add(from);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        for (String from: edges.keySet()) {
            List<String> al = new ArrayList<>();
            dfs(from, vis, al);
            if (!al.isEmpty()) {
                Collections.sort(al);
                List<String> temp = new ArrayList<>();
                temp.add(name);
                temp.addAll(al);
                ans.add(temp);
            }
        }

        return ans;
    }
}
