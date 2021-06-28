/*
 * Author: Kartik Gola
 * Date: 6/23/20 12:54 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        final int m = paragraph.length();
        final int n = banned.length;

        if ( m == 0 )
            return "";

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for ( int i = 0; i < n; ++i )
            set.add(banned[i].toLowerCase());

        int j = 0;
        for ( int i = 0; i < paragraph.length(); ++i ) {
            char ch = Character.toLowerCase( paragraph.charAt(i) );

            if ( ch >= 'a' && ch <= 'z' ) continue;
            else {
                String word = paragraph.substring(j, i).toLowerCase();
                if ( !word.isEmpty() && !set.contains(word) ) {
                    if ( map.containsKey(word) ) {
                        map.put( word, map.get(word) + 1 );
                    } else {
                        map.put( word, 1 );
                    }
                }
                j = i + 1;
            }
        }

        String lastWord = paragraph.substring(j, m).toLowerCase();
        if ( !lastWord.isEmpty() && !set.contains(lastWord) ) {
            if (map.containsKey(lastWord)) {
                map.put(lastWord, map.get(lastWord) + 1);
            } else {
                map.put(lastWord, 1);
            }
        }

        String[] words = new String[map.size()];
        map.keySet().toArray(words);

        Arrays.sort(words, (String a, String b) -> {
            return map.get(b) - map.get(a);
        });

        return words.length > 0 ? words[0] : "";
    }
}
