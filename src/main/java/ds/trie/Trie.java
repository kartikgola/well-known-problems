/*
 * Author: Kartik Gola
 * Date: 23/03/2021, 23:08
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.trie;

public class Trie {

    private final TrieNode root = new TrieNode('#');

    public TrieNode getRoot() {
        return root;
    }

    public int countLeavesDistance(TrieNode curr, int prev) {
        int sum = 0;
        for (TrieNode child: curr.children.values()) {
            if (child != null) {
                sum += countLeavesDistance(child, prev+1);
            }
        }
        return sum == 0 ? prev : sum;
    }

    public void add(String word) {
        TrieNode curr = root;
        for ( int i = 0; i < word.length(); ++i ) {
            if ( curr.children.containsKey(word.charAt(i)) ) {
                curr = curr.children.get(word.charAt(i));
            } else {
                TrieNode temp = new TrieNode(word.charAt(i));
                curr.children.put(word.charAt(i), temp);
                curr = temp;
            }
            if ( i == word.length() - 1 )
                curr.isComplete = true;
        }
    }

    public TrieNode startsWith(String prefix) {
        TrieNode curr = root;
        for ( int i = 0; i < prefix.length(); ++i ) {
            if ( curr.children.containsKey(prefix.charAt(i)) ) {
                curr = curr.children.get(prefix.charAt(i));
            } else {
                return null;
            }
        }
        return curr;
    }

    private boolean contains(String word, int offset, TrieNode parent) {
        TrieNode curr = parent;
        for ( int i = offset; i < word.length(); ++i ) {
            char ch = word.charAt(i);
            if ( ch == '.' ) {
                for ( TrieNode child : curr.children.values() ) {
                    if ( contains(word, i + 1, child) ) {
                        return true;
                    }
                }
                return false;
            } else if ( curr.children.containsKey(ch) ) {
                curr = curr.children.get(ch);
            } else {
                return false;
            }
        }
        return curr.isComplete;
    }

    public boolean contains(String word) {
        return contains(word, 0, root);
    }
}