/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddBoldTagInString {

    public String addBoldTag(String s, String[] words) {
        // a a a b b c c
        // 0 1 2 3 4 5 6
        // B   B
        //   B   B
        //         B B
        // [[0, 2], [1, 3], [4, 5]]
        // Form intervals
        List<int[]> intv = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            for (String wd: words) {
                int k = i;
                int j = 0;
                while (j < wd.length() && k < s.length()) {
                    if (s.charAt(k) == wd.charAt(j)) {
                        ++j; ++k;
                    } else break;
                }
                if (j == wd.length()) {
                    intv.add(new int[]{i, k-1});
                }
            }
        }

        // Combine the intervals
        // [[0, 2], [1, 3], [4, 5]]
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intv.size(); ++i) {
            if (ans.isEmpty()) {
                ans.add(new int[]{intv.get(i)[0], intv.get(i)[1]});
            } else {
                int[] p = ans.get(ans.size()-1);
                int[] c = intv.get(i);
                if (c[0] <= p[1] || p[1] + 1 == c[0]) {
                    p[1] = Math.max(c[1], p[1]);
                } else {
                    ans.add(new int[]{c[0], c[1]});
                }
            }
        }


        // Form the final String
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int i = 0; i < ans.size(); ++i) {
            int[] c = ans.get(i);
            while (p < c[0])
                sb.append(s.charAt(p++));
            sb.append("<b>");
            while (p <= c[1])
                sb.append(s.charAt(p++));
            sb.append("</b>");
        }

        while (p < s.length())
            sb.append(s.charAt(p++));

        return sb.toString();
    }
}
