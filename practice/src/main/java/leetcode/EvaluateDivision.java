/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class EvaluateDivision {

    private Map<String, String> root = new HashMap<>();
    private Map<String, Double> mult = new HashMap<>();

    private String find(String u) {
        if (!root.containsKey(u)) {
            root.put(u, u);
            mult.put(u, 1.0);
            return u;
        }
        if (root.get(u).equals(u))
            return u;

        String parent = root.get(u);
        String grandParent = find(parent);

        // path compression
        // example - if a/b = 2, and b/c = 3
        // then a/c = 2x3 = 6
        root.put(u, grandParent);
        mult.put(u, mult.get(u) * mult.get(parent));

        // return new root of u
        return grandParent;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); ++i) {
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            String numRoot = find(num);
            String denRoot = find(den);

            root.put(numRoot, denRoot);
            // **IMPORTANT**
            mult.put(numRoot, (1.0 / mult.get(num)) * values[i] * mult.get(den));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            String num = queries.get(i).get(0);
            String den = queries.get(i).get(1);

            if (!root.containsKey(num) || !root.containsKey(den)) {
                ans[i] = -1.0;
                continue;
            }

            String numRoot = find(num);
            String denRoot = find(den);

            if (numRoot.equals(denRoot))
                ans[i] = mult.get(num) / mult.get(den);
            else
                ans[i] = -1.0;
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
