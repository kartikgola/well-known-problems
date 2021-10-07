/*
 * Author: Kartik Gola
 * Date: 15/07/20, 7:29 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class WordSearch2 {

    private class Node {
        char val;
        String str;
        boolean isComplete;
        Map<Character, Node> map = new HashMap<>();
        Node(char val) { this.val = val; }
    }

    private final Node root = new Node('#');

    private final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); ++i) {
            curr.map.putIfAbsent(word.charAt(i), new Node(word.charAt(i)));
            curr = curr.map.get(word.charAt(i));
            if (i == word.length()-1) {
                curr.isComplete = true;
                curr.str = word;
            }
        }
    }

    private Set<String> seen = new HashSet<>();

    private List<String> f(int i, int j, Node node, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char val = board[i][j];
        board[i][j] = '#';
        if (node.map.containsKey(val)) {
            Node child = node.map.get(val);
            if (child.isComplete && !seen.contains(child.str)) {
                ans.add(child.str);
                seen.add(child.str);
            }
            for (int[] p: pos) {
                int x = p[0]+i;
                int y = p[1]+j;
                ans.addAll(f(x, y, child, board));
            }
        }
        board[i][j] = val;
        return ans;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        for (String word: words)
            addWord(word);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans.addAll(f(i, j, root, board));
            }
        }

        return ans;
    }
}
