/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.Pair;

import java.util.*;

public class OpenTheLock {

    /**
     * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * Output: 6
     * Explanation:
     * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
     * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
     * because the wheels of the lock become stuck after the display becomes the dead end "0102".
     * @param deadends
     * @param target
     * @return
     */

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>("0000", 0));

        while (!q.isEmpty()) {
            String c = q.peek().getKey();
            int v = q.poll().getValue();
            if (dead.contains(c) || visited.contains(c))
                continue;
            if (c.equals(target))
                return v;
            visited.add(c);

            for (int i = 0; i < 4; i++) {
                final int d = Character.getNumericValue(c.charAt(i));
                String next = c.substring(0, i) + ((d+1)%10) + c.substring(i+1);
                String prev = c.substring(0, i) + (d-1 < 0 ? 9 : d-1) + c.substring(i+1);
                q.add(new Pair<>(next, v+1));
                q.add(new Pair<>(prev, v+1));
            }
        }

        return -1;
    }

    public int openLock2(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>(Arrays.asList("0000", null));
        int turns = 0;

        while (!q.isEmpty()) {
            String c = q.poll();
            if (c == null) {
                turns++;
                if (!q.isEmpty())
                    q.add(null);
                continue;
            }
            if (dead.contains(c))
                continue;
            if (c.equals(target))
                return turns;
            dead.add(c);
            for (int i = 0; i < 4; i++) {
                final int d = Character.getNumericValue(c.charAt(i));
                final String before = c.substring(0, i);
                final String after = c.substring(i+1);
                q.add(before + ((d+1)%10) + after);
                q.add(before + (d-1 < 0 ? 9 : d-1) + after);
            }
        }

        return -1;
    }
}
