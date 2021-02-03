/*
 * Author: Kartik Gola
 * Date: 29/01/2021, 15:31
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/alien-dictionary/
 */

package leetcode;

import java.util.*;

public class AlienDictionary {

    private String topologicalSort(Map<Character, Set<Character>> adj) {
        StringBuilder ans = new StringBuilder();
        final int n = adj.size();
        Map<Character, Integer> indegree = new HashMap<>();

        for (Map.Entry<Character, Set<Character>> e: adj.entrySet()) {
            indegree.putIfAbsent(e.getKey(), 0);
            for (Character to: e.getValue()) {
                indegree.put(to, indegree.getOrDefault(to, 0) + 1);
            }
        }

        Set<Character> visited = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> e: indegree.entrySet()) {
            if (e.getValue() == 0) {
                q.add(e.getKey());
                visited.add(e.getKey());
            }
        }

        while (!q.isEmpty()) {
            Character u = q.remove();
            ans.append(u);
            for (Character v: adj.getOrDefault(u, new HashSet<>())) {
                if (!visited.contains(v) && indegree.containsKey(v) && indegree.get(v) - 1 == 0) {
                    q.add(v);
                    visited.add(v);
                }
            }
        }
        return ans.toString();
    }

    public String alienOrder(String[] words) {
        final Map<Character, Set<Character>> adj = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(words));

        while (!q.isEmpty()) {
            final List<String> group = q.remove();
            final Map<Character, List<Integer>> groupMap = new LinkedHashMap<>();
            for (int i = 0; i < group.size(); ++i) {
                Character ch = group.get(i).charAt(0);
                groupMap.putIfAbsent(ch, new ArrayList<>(2));
                List<Integer> range = groupMap.get(ch);
                if (range.isEmpty() || range.get(1) + 1 == i) {
                    if (range.isEmpty()) {
                        range.add(i);
                        range.add(i);
                    } else {
                        range.set(1, i);
                    }
                } else return "";
            }

            Character u = null;
            // Process the groupMap to extract groups
            for (Map.Entry<Character, List<Integer>> e: groupMap.entrySet()) {
                // Set an edge from u(prev) to v(current)
                if (u != null) {
                    adj.putIfAbsent(u, new HashSet<>());
                    adj.get(u).add(e.getKey());
                } else {
                    adj.putIfAbsent(e.getKey(), new HashSet<>());
                }
                u = e.getKey();
                List<String> al = new ArrayList<>();
                for (int i = e.getValue().get(0); i <= e.getValue().get(1); ++i) {
                    if (group.get(i).length() > 1) {
                        al.add(group.get(i).substring(1));
                    } else if (al.size() > 1) {
                        return "";
                    }
                }
                if (al.size() == 1) {
                    for (Character ch: al.get(0).toCharArray()) adj.putIfAbsent(ch, new HashSet<>());
                } else if (al.size() > 1) {
                    q.add(al);
                }
            }
        }

        return topologicalSort(adj);
    }
}
