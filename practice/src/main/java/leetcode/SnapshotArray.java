/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class SnapshotArray {

    Map<Integer, Integer> buffer = new HashMap<>();
    List<TreeMap<Integer, Integer>> al;
    int count = -1;

    public SnapshotArray(int length) {
        al = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(-1, 0);
            al.add(map);
        }
    }

    public void set(int index, int val) {
        buffer.put(index, val);
    }

    public int snap() {
        ++count;
        for (Map.Entry<Integer, Integer> e: buffer.entrySet()) {
            int idx = e.getKey();
            int val = e.getValue();
            al.get(idx).put(count, val);
        }
        buffer.clear();
        return count;
    }

    public int get(int index, int snap_id) {
        return al.get(index).floorEntry(snap_id).getValue();
    }
}
