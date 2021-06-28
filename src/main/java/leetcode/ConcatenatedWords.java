/*
 * Author: Kartik Gola
 * Date: 7/9/20 10:13 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class ConcatenatedWords {

    // Set to hold all the words
    private Set<String> set = new HashSet<>();

    // Solution from original Word Break 1 problem
    // Memoized top-down DP solution
    private boolean wordBreak(String word, Boolean[] map, int i) {
        if ( i == word.length() && !word.isEmpty() )
            return true;

        // Return memoized solution if found
        if ( map[i] != null )
            return map[i];

        for ( int j = i + 1; j <= word.length(); ++j ) {
            String str = word.substring(i, j);
            // Return true iff -
            // 1. Current string is present in set
            // 2. Current string is not equal to given word (to avoid matching words already present in set)
            //      Example, set = {"cat", "cat", "dips", "catsdips"}
            //      This check will make sure we don't return true if str is EXACTLY equal to one of above words
            //      This condition is not needed in Word Break problem
            // 3. Substring after [j, word.length) is also breakable
            if ( (set.contains(str) && !word.equals(str)) && wordBreak(word, map, j) ) {
                return map[i] = true;
            }
        }
        return map[i] = false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Collections.addAll(set, words);
        List<String> res = new LinkedList<>();
        for ( String word : words )
            if ( wordBreak(word, new Boolean[word.length() + 1], 0) )
                res.add(word);

        return res;
    }
}
