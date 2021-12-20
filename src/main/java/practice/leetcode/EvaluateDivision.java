/*
 * Author: Kartik Gola
 * Date: 10/27/21, 9:19 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class EvaluateDivision {

    private Map<String, String> root = new HashMap<>();
    private Map<String, Double> dist = new HashMap<>();

    private String find(String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s))
            return s;
        String p = root.get(s);
        String pp = find(p);
        root.put(s, pp);
        dist.put(s, dist.get(s) * dist.get(p));
        return pp;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        for (int i = 0; i < equations.size(); ++i) {
            String x1 = equations.get(i).get(0);
            String x2 = equations.get(i).get(1);
            String r1 = find(x1);
            String r2 = find(x2);
            root.put(r1, r2);
            dist.put(r1, dist.get(x2) * values[i] / dist.get(x1));
        }

        for (int i = 0; i < queries.size(); ++i) {
            String x1 = queries.get(i).get(0);
            String x2 = queries.get(i).get(1);

            if (!root.containsKey(x1) || !root.containsKey(x2)) {
                ans[i] = -1.0;
                continue;
            }

            String r1 = find(x1);
            String r2 = find(x2);
            if (!r1.equals(r2))
                ans[i] = -1.0;
            else
                ans[i] = (double) dist.get(x1) / dist.get(x2);
        }

        return ans;
    }

    private class State {
        String key;
        double val;
        State(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    // Uses BFS to get from query[0] to query[1]
    private double calc(List<String> query, Map<String, Map<String, Double>> map) {
        Queue<State> q = new LinkedList<>();
        String from = query.get(0);
        String to = query.get(1);

        if (!map.containsKey(from) || !map.containsKey(to))
            return -1.0;

        Set<String> seen = new HashSet<>();
        q.add(new State(from, 1.0));

        while (!q.isEmpty()) {
            State state = q.poll();
            if (seen.contains(state.key))
                continue;
            if (state.key.equals(to))
                return state.val;
            seen.add(state.key);
            for (Map.Entry<String, Double> e: map.getOrDefault(state.key, new HashMap<>()).entrySet()) {
                q.add(new State(e.getKey(), state.val * e.getValue()));
            }
        }

        return -1.0;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            map.putIfAbsent(num, new HashMap<>());
            map.putIfAbsent(den, new HashMap<>());
            map.get(num).put(den, values[i]);
            map.get(den).put(num, 1/values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            ans[i] = calc(queries.get(i), map);
        }

        return ans;
    }
}
