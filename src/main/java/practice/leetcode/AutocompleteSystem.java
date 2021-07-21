/*
 * Author: Kartik Gola
 * Date: 01/07/20, 9:41 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

class AutocompleteSystem {

    private class Trie {

        class Sentence {
            String val;
            int times;
            Sentence(String val, int times) {
                this.val = val;
                this.times = times;
            }
        }

        class Node {
            char val;
            int times = 0;
            boolean isComplete = false;
            Map<Character, Node> children = new HashMap<>();
            Node(char val) { this.val = val; }
        }

        Node root = new Node('#');
        Trie() {}

        public void insert(String word, int times) {
            Node curr = root;
            for ( int i = 0; i < word.length(); ++i ) {
                char ch = word.charAt(i);
                if ( curr.children.containsKey(ch) ) {
                    curr = curr.children.get(ch);
                } else {
                    Node newChild = new Node(ch);
                    curr.children.put(ch, newChild);
                    curr = newChild;
                }
                if ( i == word.length() - 1 ) {
                    curr.isComplete = true;
                    curr.times += times;
                }
            }
        }

        private List<Sentence> allWordsBelow(Node node) {
            List<Sentence> res = new ArrayList<>();
            if ( node.isComplete )
                res.add( new Sentence(node.val + "", node.times) );

            List<Sentence> subRes = new ArrayList<>();
            for ( Map.Entry<Character, Node> e : node.children.entrySet() )
                subRes.addAll( allWordsBelow(e.getValue()) );

            for ( Sentence st : subRes ) {
                st.val = node.val + st.val;
                res.add( st );
            }

            return res;
        }

        public List<String> startsWith(String prefix) {
            List<String> res = new ArrayList<>();
            if ( prefix.isEmpty() )
                return res;

            Node curr = root;
            int j = 0;
            for ( j = 0; j < prefix.length(); ++j ) {
                char ch = prefix.charAt(j);
                if ( curr.children.containsKey(ch) )
                    curr = curr.children.get(ch);
                else return res;
            }

            List<Sentence> sentences = allWordsBelow(curr);
            for ( Sentence st : sentences )
                st.val = prefix.substring(0, j - 1) + st.val;

            Collections.sort(sentences, (Sentence s1, Sentence s2) -> {
                if ( s2.times - s1.times != 0 )
                    return s2.times - s1.times;
                return s1.val.compareTo(s2.val);
            });

            for ( int i = 0; i < sentences.size() && i < 3; ++i )
                res.add( sentences.get(i).val );

            return res;
        }
    }

    Trie t;
    String query;

    public AutocompleteSystem(String[] sentences, int[] times) {
        t = new Trie();
        query = "";
        for ( int i = 0; i < sentences.length; ++i )
            t.insert(sentences[i], times[i]);
    }

    public List<String> input(char c) {
        if ( c == '#' ) {
            t.insert(query, 1);
            query = "";
            return new ArrayList<>();
        } else {
            query += c;
            return t.startsWith(query);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */