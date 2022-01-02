/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
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
