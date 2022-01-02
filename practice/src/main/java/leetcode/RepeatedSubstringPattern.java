/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Objects;

import static util.StringUtils.isEqualInParts;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (Objects.isNull(s) || s.length() <= 1 )
            return false;
        if ( s.length() == 2 )
            return s.charAt(0) == s.charAt(1);
        final int n = s.length();
        int maxDivisor = (int) Math.floor(Math.sqrt(n));
        for ( int d = maxDivisor; d >= 1; --d ) {
            if ( d != 1 && n % d == 0 && (isEqualInParts(s, n / d) || isEqualInParts(s, d)) ) {
                return true;
            } else if ( isEqualInParts(s, n) ) {
                return true;
            }
        }
        return false;
    }
}
