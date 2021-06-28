/*
 * Author: Kartik Gola
 * Date: 15/07/20, 7:29 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import util.ds.trie.Trie;
import util.ds.trie.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    Trie t;
    int m, n;
    final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private List<String> dfs(char[][] board, int i, int j, boolean[][] vis, TrieNode parent) {
        List<String> res = new ArrayList<>();
        if ( i < 0 || i >= m || j < 0 || j >= n || vis[i][j] )
            return res;
        TrieNode current = null;
        if ( parent == null ) current = t.getNode(Character.toString(board[i][j]));
        else current = parent.children.getOrDefault(board[i][j], null);

        if ( current == null )
            return res;

        vis[i][j] = true;
        for ( int[] p : pos ) {
            List<String> subRes = dfs(board, i + p[0], j + p[1], vis, current);
            for ( String wd : subRes )
                res.add(board[i][j] + wd);
        }

        if ( current.isComplete ) {
            res.add(Character.toString(board[i][j]));
        }

        vis[i][j] = false;
        return res;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.t = new Trie();
        this.m = board.length;
        this.n = board[0].length;

        for ( String word : words )
            t.add(word);

        boolean[][] vis = new boolean[m][n];
        Set<String> set = new HashSet<>();
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                for ( String wd : dfs(board, i, j, vis, null) ) {
                    set.add(wd);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
