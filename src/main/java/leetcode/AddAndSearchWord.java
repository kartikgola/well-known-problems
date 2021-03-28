/*
 * Author: Kartik Gola
 * Date: 8/5/20 7:48 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import ds.trie.Trie;

public class AddAndSearchWord {

    class WordDictionary {

        Trie t;

        /** Initialize your data structure here. */
        public WordDictionary() {
            t = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            t.add(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return t.contains(word);
        }
    }
}
