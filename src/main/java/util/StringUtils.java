/*
 * Author: Kartik Gola
 * Date: 17/09/2020, 21:57
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package util;

import java.util.Objects;

public class StringUtils {

    /**
     * Checks if a string of length `n` can be evenly divided in `parts` partitions such that
     * each string all the string partitions are equal
     * @param str
     * @param parts
     * @return true if `str` can be divided into equal `parts` partitions
     */
    public static boolean isEqualInParts(String str, int parts) {
        if (Objects.isNull(str) || str.isEmpty() || parts < 0)
            return false;
        final int n = str.length();
        if ( n % parts == 0 ) {
            final int partsLength = n / parts;
            String prev = null;
            // O(parts * (2 * partsLength))
            for ( int begin = 0, end = partsLength; end <= str.length(); begin = end, end += partsLength ) {
                String part = str.substring(begin, begin + partsLength);
                if ( prev != null && !prev.equals(part) ) {
                    return false;
                }
                prev = part;
            }
            return true;
        }
        return false;
    }
}
