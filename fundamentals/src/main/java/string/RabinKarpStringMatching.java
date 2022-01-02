/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package string;

import java.io.IOException;

public class RabinKarpStringMatching {

    final int C = 26;

    private long getHash(String s) {
        final int k = s.length() - 1;
        long hash = 0;
        for ( int i = 0; i < s.length(); ++i ) {
            hash += Math.pow(C, k - i) * (s.charAt(i) - 'a');
        }
        return hash;
    }

    private long rollHash(long prevHash, char prevChar, char newChar, int len) {
        prevHash -= Math.pow(C, len - 1) * (prevChar - 'a');
        prevHash *= C;
        prevHash += Math.pow(C, 0) * (newChar - 'a');
        return prevHash;
    }

    public boolean solve(String text, String pattern) throws IOException {
        if ( pattern.length() > text.length() ) return false;
        if ( pattern.isEmpty() ) return true;

        long patternHash = getHash(pattern);
        long textHash = 0;
        for ( int i = 0; i <= text.length() - pattern.length(); ++i ) {
            if ( i == 0 ) {
                textHash = getHash(text.substring(0, pattern.length()));
            } else {
                textHash = rollHash(textHash, text.charAt(i - 1),
                        text.charAt(i + pattern.length() - 1), pattern.length());
            }
            if ( textHash == patternHash )
                return true;
        }

        return false;
    }
}
