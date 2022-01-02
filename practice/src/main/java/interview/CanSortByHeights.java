/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package interview;

import java.util.*;

public class CanSortByHeights {

    public boolean solve(List<char[]> relations) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (char[] relation: relations) {
            // relation[] = [A, B] which means A > B
            char from = relation[0]; // A
            char to = relation[1]; // B
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);

            degree.putIfAbsent(from, 0);
            degree.putIfAbsent(to, 0);
            degree.put(to, degree.getOrDefault(to, 0)+1);
        }

        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> e: degree.entrySet()) {
            if (e.getValue() == 0) {
                q.add(e.getKey());
            }
        }

        while (!q.isEmpty()) {
            char curr = q.poll();
            if (!q.isEmpty())
                return false;
            for (char next: map.getOrDefault(curr, new ArrayList<>())) {
                degree.put(next, degree.get(next)-1);
                if (degree.get(next) == 0) {
                    q.add(next);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanSortByHeights().solve(Arrays.asList(new char[]{'A', 'B'}, new char[]{'B', 'C'})));
    }
}
