/*
 * Author: Kartik Gola
 * Date: 15/07/20, 8:09 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

public class Trie {

    TrieNode root = new TrieNode('#');

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

    public TrieNode exists(String prefix) {
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
}