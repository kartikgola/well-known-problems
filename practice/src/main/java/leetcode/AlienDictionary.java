/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.GraphUtils;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        final Map<Character, Set<Character>> adj = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(words));

        while (!q.isEmpty()) {
            final List<String> group = q.remove();
            List<String> nextGroup = new ArrayList<>();
            Character curr = null;
            for (String word: group) {
                if (curr == null || word.charAt(0) == curr) {
                    curr = word.charAt(0);
                    if (word.length() > 1) {
                        nextGroup.add(word.substring(1));
                    } else if (!nextGroup.isEmpty())
                        return "";
                } else {
                    adj.get(curr).add(word.charAt(0));
                    if (!nextGroup.isEmpty()) {
                        q.add(nextGroup);
                        nextGroup = new ArrayList<>();
                    }
                    curr = word.charAt(0);
                    if (word.length() > 1) {
                        nextGroup.add(word.substring(1));
                    }
                }
                adj.putIfAbsent(curr, new HashSet<>());
            }
            if (!nextGroup.isEmpty()) {
                q.add(nextGroup);
            }
        }

        final List<Character> topologicalOrder = GraphUtils.topologicalSort(adj);
        if (topologicalOrder == null || topologicalOrder.isEmpty())
            return "";

        return topologicalOrder.stream().map(Object::toString).collect(Collectors.joining());
    }
}
