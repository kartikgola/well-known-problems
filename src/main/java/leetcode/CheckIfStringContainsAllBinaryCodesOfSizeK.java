/*
 * Author: Kartik Gola
 * Date: 12/03/2021, 16:01
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        Set<String> numbers = new HashSet<>();
        for (int i = 0; i <= s.length() - k; ++i) {
            numbers.add(s.substring(i, i+k));
        }
        return numbers.size() == 1 << k;
    }
}
