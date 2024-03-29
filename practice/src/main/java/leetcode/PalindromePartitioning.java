/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class PalindromePartitioning {

    private List<List<String>> partition(String s, boolean[][] pd, int i) {
        List<List<String>> ans = new ArrayList<>();
        if (i >= s.length())
            ans.add(Collections.emptyList());
        for (int j = i; j < s.length(); ++j) {
            if (pd[i][j]) {
                List<List<String>> subParts = partition(s, pd, j+1);
                for (List<String> parts: subParts) {
                    List<String> al = new ArrayList<>();
                    al.add(s.substring(i, j+1));
                    al.addAll(parts);
                    ans.add(al);
                }
            }
        }
        return ans;
    }

    public List<List<String>> partition(String s) {
        boolean[][] pd = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); ++l) {
            for (int i = 0; i+l < s.length(); ++i) {
                int j = i+l;
                if (l == 0)
                    pd[i][j] = true;
                else
                    pd[i][j] = s.charAt(i) == s.charAt(j) && (l <= 1 || pd[i + 1][j - 1]);
            }
        }
        return partition(s, pd, 0);
    }

}
