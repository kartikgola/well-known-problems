/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {

    private final List<Integer> ans = new ArrayList<>();

    private void killRecursively(int ppid, Map<Integer, List<Integer>> childMap) {
        ans.add(ppid);
        for (Integer pid: childMap.getOrDefault(ppid, new ArrayList<>()))
            killRecursively(pid, childMap);
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        final int n = pid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        killRecursively(kill, map);
        return ans;
    }
}
