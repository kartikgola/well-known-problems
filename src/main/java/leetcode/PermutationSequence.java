/*
 * Author: Kartik Gola
 * Date: 21/06/20, 12:58 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class PermutationSequence {

    private int getFact(int n) {
        int f = 1;
        for ( int x = 1; x <= n; ++x )
            f = f * x;
        return f;
    }

    private String getStringUptoN(int n) {
        String str = "";
        for ( int x = 1; x <= n; ++x )
            str += x;
        return str;
    }

    public String getPermutation(int n, int k) {
        int m = n;
        int q = k - 1;
        int f = getFact(m);

        StringBuilder sb = new StringBuilder(getStringUptoN(m));
        StringBuilder res = new StringBuilder();
        int each, group, offset;

        while ( m > 0 ) {
            // Permutations in each group
            each = f / m;
            // Index of group
            group = q / each;
            // Character at 'group' indicates the parent char of group
            res.append(sb.charAt(group));
            // Remove the parent char
            sb.deleteCharAt(group); // "123"
            // Offset of permutations within group
            offset = q % each; // 1

            f = f / m;
            m = m - 1;
            q = offset;
        }

        return res.toString();
    }
}
