/*
 * Author: Kartik Gola
 * Date: 8/27/21, 5:59 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class LongestUncommonSubsequence {

    public int findLUSlength(String a, String b) {
        return a.length() == b.length() ? (a.equals(b) ? -1 : a.length()) : Math.max(a.length(), b.length());
    }
}
