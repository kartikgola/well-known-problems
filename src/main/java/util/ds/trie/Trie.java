/*
 * Author: Kartik Gola
 * Date: 23/03/2021, 23:08
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util.ds.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {

    private final TrieNode root = new TrieNode('#');

    public TrieNode getRoot() {
        return root;
    }

    private TrieNode addNode(String word) {
        TrieNode curr = root;
        for ( int i = 0; i < word.length(); ++i ) {
            if ( curr.children.containsKey(word.charAt(i)) ) {
                curr = curr.children.get(word.charAt(i));
            } else {
                TrieNode temp = new TrieNode(word.charAt(i));
                curr.children.put(word.charAt(i), temp);
                curr = temp;
            }
        }
        return curr;
    }

    // Addition of a new word
    public void add(String word) {
        final TrieNode node = addNode(word);
        if (node != root)
            node.isComplete = true;
    }

    public void add(String word, int id) {
        final TrieNode node = addNode(word);
        if (node != root) {
            node.isComplete = true;
            node.id = id;
        }
    }

    public TrieNode getNode(String prefix) {
        TrieNode curr = root;
        for ( int i = 0; i < prefix.length(); ++i ) {
            if ( curr.children.containsKey(prefix.charAt(i)) ) {
                curr = curr.children.get(prefix.charAt(i));
            } else {
                return null;
            }
        }
        return curr == root ? null : curr;
    }

    // Check if a word is present in Trie
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

    // Returns the ID of the word present in Trie
    public int getWordId(String word) {
        TrieNode curr = root;
        for ( int i = 0; i < word.length(); ++i ) {
            char ch = word.charAt(i);
            if ( curr.children.containsKey(ch) ) {
                curr = curr.children.get(ch);
            } else {
                return -1;
            }
        }
        return curr.isComplete ? curr.id : -1;
    }

    // Find IDs of all complete words present below the given node
    private List<Integer> getWordIdsBelow(TrieNode node) {
        List<Integer> ans = new ArrayList<>();
        for (TrieNode child: node.children.values())
            ans.addAll(getWordIdsBelow(child));
        if (node.isComplete)
            ans.add(node.id);
        return ans;
    }

    public List<Integer> getWordIdsBelow(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children.containsKey(prefix.charAt(i))) {
                curr = curr.children.get(prefix.charAt(i));
            } else return Collections.emptyList();
        }
        return getWordIdsBelow(curr);
    }
}