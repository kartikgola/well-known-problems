/*
 * Author: Kartik Gola
 * Date: 23/03/2021, 20:02
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public char val;
    public boolean isComplete;
    public Map<Character, TrieNode> children = new HashMap<>();
    public TrieNode(char val) { this.val = val; }

}