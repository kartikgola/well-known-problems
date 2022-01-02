/*
 * Author: Kartik Gola
 * Date: 23/03/2021, 23:09
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package trie;

import java.util.*;

public class TrieNode {
    public char val;
    public int id;
    public boolean isComplete;
    public Map<Character, TrieNode> children = new LinkedHashMap<>();
    public TrieNode(char val) { this.val = val; }
}