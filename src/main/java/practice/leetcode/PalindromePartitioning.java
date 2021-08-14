/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class PalindromePartitioning {

    private List<List<String>> f(String s, boolean[][] pd, int i) {
        List<List<String>> ans = new ArrayList<>();
        if (i >= s.length())
            ans.add(Collections.emptyList());
        for (int j = i; j < s.length(); ++j) {
            if (pd[i][j]) {
                List<List<String>> sub = f(s, pd, j+1);
                for (List<String> su: sub) {
                    List<String> al = new ArrayList<>();
                    al.add(s.substring(i, j+1));
                    al.addAll(su);
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
        return f(s, pd, 0);
    }

}
