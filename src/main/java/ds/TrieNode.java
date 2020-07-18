/*
 * Author: Kartik Gola
 * Date: 15/07/20, 8:10 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

public class TrieNode {

    public char val;
    public boolean isComplete;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(char val) { this.val = val; }

}