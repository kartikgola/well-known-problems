/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsets {

    private String subsequences(String word) {
        // abc,ab,bc,ac,a,b,c,
        if ( word.isEmpty() ) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);
            String subsequenceOfRest = subsequences(restOfWord);

            for ( String subsequence : subsequenceOfRest.split(",", -1) ) {
                builder.append(",").append(subsequence);
                builder.append(",").append(firstLetter).append(subsequence);
            }
            builder.deleteCharAt(0);
            return builder.toString();
        }
    }

    private String subsequences2(String word) {
        return _subsequences2("", word);
    }

    private String _subsequences2(String partial, String word) {
        if ( word.isEmpty() ) {
            return "";
        } else {
            return _subsequences2(partial, word.substring(1))
                    + ","
                    + _subsequences2(partial + word.charAt(0), word.substring(1));
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        System.out.println(subsequences(word));
    }
}
