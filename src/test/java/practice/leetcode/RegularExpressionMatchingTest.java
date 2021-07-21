package practice.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void isMatch() {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        assertTrue(new RegularExpressionMatching().isMatch("a", "ab*"));
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "a*"));
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "aa*"));
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "a*a"));
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "aaa*"));
        assertTrue(new RegularExpressionMatching().isMatch("aaabc", "a*bc"));
        assertFalse(new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
    }
}