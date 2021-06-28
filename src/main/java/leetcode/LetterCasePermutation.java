/*
 * Author: Kartik Gola
 * Date: 2/16/21, 8:22 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/letter-case-permutation/
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private List<String> permute(String s, int begin) {
        List<String> ans = new ArrayList<>();
        if (begin >= s.length())
            return ans;

        List<String> subAns = permute(s, begin +1);
        if (subAns.isEmpty())
            subAns.add("");
        if (s.charAt(begin) >= '0' && s.charAt(begin) <= '9') {
            for (String sub: subAns)
                ans.add(s.charAt(begin) + sub);
        } else {
            for (String sub: subAns) {
                ans.add(Character.toString(s.charAt(begin)).toLowerCase() + sub);
                ans.add(Character.toString(s.charAt(begin)).toUpperCase() + sub);
            }
        }
        return ans;
    }

    public List<String> letterCasePermutation(String S) {
        return permute(S, 0);
    }
}
