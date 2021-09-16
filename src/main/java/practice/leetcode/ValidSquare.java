/*
 * Author: Kartik Gola
 * Date: 9/16/21, 7:43 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] pt = {p1, p2, p3, p4};

        for (int i = 0; i < pt.length; ++i) {
            for (int j = i+1; j < pt.length; ++j) {
                int x = (pt[i][0]-pt[j][0]) * (pt[i][0]-pt[j][0]);
                int y = (pt[i][1]-pt[j][1]) * (pt[i][1]-pt[j][1]);
                map.put(x+y, map.getOrDefault(x+y, 0) + 1);
            }
        }

        if (map.size() != 2)
            return false;

        int big = Integer.MIN_VALUE, small = Integer.MAX_VALUE;
        for (int key: map.keySet()) {
            big = Math.max(big, key);
            small = Math.min(small, key);
        }

        return map.get(small) == 4 && map.get(big) == 2 && big == small * 2;
    }

    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        int[][] pt = {p1, p2, p3, p4};

        for (int i = 0; i < pt.length; ++i) {
            for (int j = i+1; j < pt.length; ++j) {
                int x = (pt[i][0]-pt[j][0]) * (pt[i][0]-pt[j][0]);
                int y = (pt[i][1]-pt[j][1]) * (pt[i][1]-pt[j][1]);
                set.add(x+y);
            }
        }

        return !set.contains(0) && set.size() == 2;
    }

    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean validSquare3(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1,p2,p3,p4};
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);
    }

}
