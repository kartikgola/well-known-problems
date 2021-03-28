/*
 * Author: Kartik Gola
 * Date: 23/03/2021, 23:09
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.trie;

import java.util.*;

public class TrieNode {

    public char val;
    public boolean isComplete;
    public Map<Character, TrieNode> children = new LinkedHashMap<>();
    public TrieNode(char val) { this.val = val; }

}