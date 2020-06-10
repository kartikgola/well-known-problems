/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import org.junit.Test;

class PalindromePartitioningTest {

    @Test
    void isPalindrome() {
        PalindromePartitioning pp = new PalindromePartitioning();
        String[] test = new String[]{"a", "aa", "aaa", "aba", "abba", "abca", "abcba", "abc", "ab"};
        boolean[] exp = new boolean[]{true, true, true, true, true, false, true, false, false};
    }

}