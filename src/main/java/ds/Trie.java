/*
 * Author: Kartik Gola
 * Date: 15/07/20, 8:09 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

public class Trie {

    private final TrieNode root = new TrieNode('#');
    private int leavesDistance = 0;

    public TrieNode getRoot() {
        return root;
    }

    public int getLeavesDistance() {
        countLeavesDistance(root, 0);
        return leavesDistance;
    }

    public int countLeavesDistance(TrieNode curr, int prev) {
        int sum = 0;
        for (TrieNode child: curr.children) {
            if (child != null) {
                sum += countLeavesDistance(child, prev+1);
            }
        }
        return sum == 0 ? prev : sum;
    }

    public void add(String word) {
        TrieNode curr = root;
        for ( int i = 0; i < word.length(); ++i ) {
            if ( curr.children[ word.charAt(i) - 'a' ] != null ) {
                curr = curr.children[ word.charAt(i) - 'a' ];
            } else {
                TrieNode temp = new TrieNode(word.charAt(i));
                curr.children[ word.charAt(i) - 'a' ] = temp;
                curr = temp;
            }
            if ( i == word.length() - 1 )
                curr.isComplete = true;
        }
    }

    public TrieNode startsWith(String prefix) {
        TrieNode curr = root;
        for ( int i = 0; i < prefix.length(); ++i ) {
            if ( curr.children[ prefix.charAt(i) - 'a' ] != null ) {
                curr = curr.children[ prefix.charAt(i) - 'a' ];
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
                for ( TrieNode child : curr.children ) {
                    if ( child != null && contains(word, i + 1, child) ) {
                        return true;
                    }
                }
                return false;
            } else if ( curr.children[ch - 'a'] != null ) {
                curr = curr.children[ch - 'a'];
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