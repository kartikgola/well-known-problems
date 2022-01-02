/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class LongestUncommonSubsequence {

    public int findLUSlength(String a, String b) {
        return a.length() == b.length() ? (a.equals(b) ? -1 : a.length()) : Math.max(a.length(), b.length());
    }
}
