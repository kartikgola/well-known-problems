/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        final int n = s.length();
        final int m = words.length;
        if ( m == 0 ) return ans;
        final int k = words[0].length();

        // Map of counts available for words
        Map<String, Integer> map = new HashMap<>();
        for ( String word : words )
            map.put(word, map.getOrDefault(word, 0) + 1);
        // Map of remaining counts of words
        Map<String, Integer> rem = new HashMap<>(map);

        // Since each word in `words` is of length `k`
        // All the possible windows should be of length `m * k`
        // Total such windows in a string of length `n` would be `n - (m * k) + 1`
        for ( int i = 0; i < n - (m * k) + 1; ++i ) {
            // Take each possible window of size `m * k`
            String str = s.substring(i, i + m * k);
            int match = 0;
            for ( int j = 0; j < str.length(); j += k ) {
                // For each possible word of size `k`, we check if it is present in rem & decrease its count
                String wd = str.substring(j, j + k);
                if (rem.getOrDefault(wd, 0) > 0) {
                    rem.put(wd, rem.get(wd) - 1);
                    ++match;
                } else // Since we want continuous words, we break even on the first mismatch
                    break;
            }
            if ( match > 0 ) {
                // Number of match should be equal to `m`
                if ( match == m )
                    ans.add(i);
                // Reset `rem` for next window
                for ( Map.Entry<String, Integer> e : map.entrySet() )
                    rem.put(e.getKey(), e.getValue());
            }
        }

        return ans;
    }
}
