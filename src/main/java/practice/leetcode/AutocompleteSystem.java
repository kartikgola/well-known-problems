/*
 * Author: Kartik Gola
 * Date: 01/07/20, 9:41 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

class AutocompleteSystem {

    private class Node {
        char val;
        int times;
        boolean isComplete;
        String str;
        Map<Character, Node> map = new HashMap<>();
        Node(char val) {
            this.val = val;
        }
    }

    private final Node root = new Node('#');
    // represents the previous Node of recently typed char
    private Node prev = root;
    // store the string of types chars
    private StringBuilder typed = new StringBuilder();

    private void add(String str, int times) {
        Node curr = root;
        for (int i = 0; i < str.length(); ++i) {
            curr.map.putIfAbsent(str.charAt(i), new Node(str.charAt(i)));
            curr = curr.map.get(str.charAt(i));
            if (i == str.length()-1) {
                curr.isComplete = true;
                curr.times += times;
                curr.str = str;
            }
        }
    }

    // gets all nodes below curr node
    private void nodesBelow(Node curr, List<Node> al) {
        if (curr.isComplete)
            al.add(curr);
        for (Node child: curr.map.values()) {
            nodesBelow(child, al);
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; ++i) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            prev = root;
            add(typed.toString(), 1);
            typed = new StringBuilder();
            return Collections.emptyList();
        }
        typed.append(c);
        if (prev == null)
            return Collections.emptyList();

        prev = prev.map.getOrDefault(c, null);
        if (prev == null)
            return Collections.emptyList();

        List<Node> al = new ArrayList<>();
        nodesBelow(prev, al);
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.times - n2.times != 0 ? n1.times - n2.times : n2.str.compareTo(n1.str));
        for (Node node: al) {
            pq.offer(node);
            if (pq.size() > 3)
                pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().str);
        }
        Collections.reverse(ans);
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */