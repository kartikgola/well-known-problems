/*
 * Author: Kartik Gola
 * Date: 7/20/20 12:11 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/delete-operation-for-two-strings/
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {

    private List<String> gen(int o, int c) { // o = open braces left, c = closed braces left
        if (o == 0) return Collections.singletonList(")".repeat(c));
        if (o > c) return Collections.emptyList();

        List<String> ans = new ArrayList<>();
        for (String v: gen(o-1, c))
            ans.add("(" + v); // Consume open brace

        for (String v: gen(o, c-1))
            ans.add(")" + v); // Consume close brace

        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return gen(n,n);
    }
}
