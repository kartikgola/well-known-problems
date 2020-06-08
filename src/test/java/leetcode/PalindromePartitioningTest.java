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