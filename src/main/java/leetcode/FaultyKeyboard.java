/*
 * Author: Kartik Gola
 * Date: 8/8/20 1:42 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/discuss/interview-experience/778039/google-phone-interview-rejected
 */

package leetcode;

import util.ds.trie.Trie;
import util.ds.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class FaultyKeyboard {

    /**
     * Calculates all possible strings that can be typed in interval input[offset, input.length)
     * @param input : Original string input of problem
     * @param offset : Offset or starting index
     * @param trie : Trie
     * @param faultyChar : Faulty character of the keyboard
     * @param str : String created till this point
     * @return : List<String>
     */
    private List<String> possibleStrings(String input, int offset, Trie trie, final char faultyChar, String str) {
        List<String> ans = new ArrayList<>();
        if ( offset == input.length() )
            return ans;

        TrieNode curr = trie.getRoot();
        for ( int i = offset; i < input.length(); ++i ) {
            char ch = input.charAt(i);
            if ( ch == ' ' ) {
                // ch can be actual space
                if ( curr.isComplete )
                    ans.addAll(possibleStrings(input, i + 1, trie, faultyChar, str + ch));
                // or, it can be the faultyChar
                ch = faultyChar;
            }
            // Check if we can use ch to extend ongoing str
            if ( curr.children.containsKey(ch) ) {
                curr = curr.children.get(ch);
                str += ch;
            } else if ( curr.isComplete && trie.getRoot().children.containsKey(ch) ) {
                // Check if we can end str with ch & start a new word with ch
                str += ch;
                curr = trie.getRoot().children.get(ch);
            } else {
                return ans;
            }
        }

        // Only add str to answer, if there exists a word in dictionary
        if ( curr.isComplete )
            ans.add(str);
        return ans;
    }

    /**
     * @param input : "can s r n"
     * @param dictionary : ["can", "canes", "serene", "rene", "sam"]
     * @return List<String> that were possibly typed by the user
     */
    public List<String> possibleStrings(String input, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for ( String word : dictionary )
            trie.add(word);
        final char faultyChar = 'e';
        return possibleStrings(input, 0, trie, faultyChar, "");
    }
}
