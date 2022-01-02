/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class WordLadder2 {

    class Word {
        String word;
        List<Word> nexts = new ArrayList<>();
        int level;
        boolean isLast;
        Word( String word, int level ) {
            this.word = word;
            this.level = level;
        }
        Word( String word, int level, boolean isLast ) {
            this.word = word;
            this.level = level;
            this.isLast = isLast;
        }
        public String toString() {
            return "word: " + word + " level: " + level + " nexts:" + nexts;
        }
    }

    private List<List<String>> dfs(Word word, boolean first) {
        List<List<String>> res = new ArrayList<>();
        if ( word.nexts.size() == 0 && word.isLast ) {
            List<String> al = new ArrayList<>();
            al.add( word.word );
            res.add( al );
        } else {
            for ( Word nextWord : word.nexts )
                res.addAll( dfs(nextWord, false) );

            for ( List<String> al : res )
                al.add(0, word.word);
        }
        return res;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> finalRes = new ArrayList<>();

        if ( !wordList.contains(endWord) )
            return new ArrayList<>();

        if ( beginWord.equals( endWord ) ) {
            finalRes.add( Arrays.asList(beginWord) );
            return finalRes;
        }

        final int L = beginWord.length();
        Map<String, List<String>> dict = new HashMap<>();
        for ( String word : wordList ) {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> trans = dict.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                dict.put(newWord, trans);
            }
        }

        Queue<Word> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(new Word(beginWord, 1));
        vis.add(beginWord);
        Word head = null;

        while ( !q.isEmpty() ) {
            Word wordObj = q.poll();
            String qword = wordObj.word;
            int level = wordObj.level;
            // Mark it visited, only when it is being processed
            // As we can have branching factor of more than 1
            vis.add(qword);

            if ( head == null )
                head = wordObj;

            for ( int i = 0; i < L; ++i ) {
                String qwordNew = qword.substring(0, i) + '*' + qword.substring(i + 1, L);
                for ( String nextWord : dict.getOrDefault(qwordNew, new ArrayList<>()) ) {
                    if ( nextWord.equals(endWord) )
                        wordObj.nexts.add( new Word(endWord, level + 1, true) );
                    else if ( !vis.contains(nextWord) ) {
                        Word temp = new Word(nextWord, level + 1);
                        q.add( temp );
                        wordObj.nexts.add( temp );
                    }
                }
            }
        }

        List<List<String>> res = dfs(head, true);
        int minLen = Integer.MAX_VALUE;
        for ( int i = 0; i < res.size(); ++i )
            minLen = Math.min(minLen, res.get(i).size());

        for ( List<String> subRes : res ) {
            if ( subRes.size() == minLen )
                finalRes.add( subRes );
        }

        return finalRes;
    }
}
