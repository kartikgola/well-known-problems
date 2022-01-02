/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        boolean pos = true;
        int i = 0;

        // check sign
        if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
            pos = s.charAt(i++) == '+';

        // check digits
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                if (sb.length() == 0)
                    return 0;
                else break;
            }
        }

        // remove initial zeros
        for (int k = 0; k < sb.length() && sb.charAt(k) == '0';)
            sb.delete(k, k+1);

        long ans = 0;
        if (pos && sb.length() > String.valueOf(Integer.MAX_VALUE).length())
            return Integer.MAX_VALUE;
        if (!pos && sb.length() > String.valueOf(Integer.MIN_VALUE).length()-1)
            return Integer.MIN_VALUE;

        for (int j = 0; j < sb.length(); ++j) {
            int v = sb.charAt(j) - '0';
            if (v > 0) {
                if (pos)
                    ans += Math.pow(10, sb.length()-j-1) * v;
                else
                    ans -= Math.pow(10, sb.length()-j-1) * v;
            }
        }

        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) ans;
    }
}
