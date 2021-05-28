/*
 * Author: Kartik Gola
 * Date: 7/20/20 12:11 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/delete-operation-for-two-strings/
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private String repeat(Character ch, int times) {
        StringBuilder sb = new StringBuilder(times);
        while ( times-- > 0 ) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private void gen(int op, int cl, String str, List<String> res) {
        if ( op == 0 ) {
            res.add(str + repeat(')', cl));
        } else if ( cl == 0 ) {
            res.add(str);
        } else {
            gen(op - 1, cl, str + '(', res);
            if ( str.length() > 0 && str.charAt(str.length() - 1) == '(' )
                gen(op, cl - 1, str + ')', res);
            if ( str.length() > 0 && str.charAt(str.length() - 1) == ')' && op < cl )
                gen(op, cl - 1, str + ')', res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(n, n, "", res);
        return res;
    }
}
