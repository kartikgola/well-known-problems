/*
 * Author: Kartik Gola
 * Date: 12/8/21, 11:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {

    /**
     * use 'pass' to keep track of current password
     * use 'vis' to store the states that have been visited so far (not password)
     * whenever size(vis) == limit, we know that all states have been visited
     * with n=2, k=2; we have following adjacency map between k^n = 4 states
     * {
     *     00 = [01],
     *     01 = [10, 11],
     *     10 = [00, 01],
     *     11 = [10]
     * }
     * This algorithm essentially finds a Hamiltonian Cycle
     * More info at https://en.wikipedia.org/wiki/De_Bruijn_sequence
     */
    private boolean dfs(StringBuilder pass, Set<String> vis, int limit, int n, int k) {
        if (vis.size() == limit)
            return true;
        // Get the last (n-1) length string, so that we can figure out next state by appending a value in [0,k-1]
        String sub = pass.substring(pass.length()-n+1);
        for (int i = 0; i < k; ++i) {
            String next = sub + i;
            if (!vis.contains(next)) {
                vis.add(next);
                pass.append(i);
                if (dfs(pass, vis, limit, n, k))
                    return true;
                pass.deleteCharAt(pass.length()-1);
                vis.remove(next);
            }
        }
        return false;
    }

    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder("0".repeat(n));
        Set<String> vis = new HashSet<>();
        vis.add(sb.toString());
        dfs(sb, vis, (int) Math.pow(k, n), n, k);
        return sb.toString();
    }
}
