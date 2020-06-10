/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package algo;

import util.Utils;

import java.io.IOException;

public class RabinKarpStringMatching {

    final int C = 26;

    private long getHash(String s) {
        final int k = s.length() - 1;
        long hash = 0;
        for ( int i = 0; i < s.length(); ++i ) {
            hash += Utils.fastPow(C, k - i) * (s.charAt(i) - 'a');
        }
        return hash;
    }

    private long rollHash(long prevHash, char prevChar, char newChar, int len) {
        prevHash -= Utils.fastPow(C, len - 1) * (prevChar - 'a');
        prevHash *= C;
        prevHash += Utils.fastPow(C, 0) * (newChar - 'a');
        return prevHash;
    }

    public boolean solve(String text, String patt) throws IOException {
        if ( patt.length() > text.length() ) return false;
        if ( patt.isEmpty() ) return true;

        long pattHash = getHash(patt);
        long textHash = 0;
        for ( int i = 0; i <= text.length() - patt.length(); ++i ) {
            if ( i == 0 ) {
                textHash = getHash(text.substring(0, patt.length()));
            } else {
                textHash = rollHash(textHash, text.charAt(i - 1),
                        text.charAt(i + patt.length() - 1), patt.length());
            }
            if ( textHash == pattHash )
                return true;
        }

        return false;
    }
}
