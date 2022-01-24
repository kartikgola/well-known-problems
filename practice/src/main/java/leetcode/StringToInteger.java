/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;

        boolean pos = s.charAt(0) == '-';
        int offset = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;

        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
            else break;
        }

        if (sb.length() == 0)
            return 0;

        if (sb.charAt(0) == '0') {
            int i = 0;
            while (i+1 < sb.length() && sb.charAt(i+1) == '0')
                i++;
            sb.delete(0, i+1);
            if (sb.length() == 0)
                return 0;
        }

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int len = (int)(Math.log(max) / Math.log(10)) + 1;

        if (sb.length() > len)
            return pos ? max : min;
        else if (sb.length() < len)
            return Integer.parseInt((pos ? "" : "-") + sb.toString());

        // limit is the maximum or minimum string to compare with
        // limit should only be the absolute value without any + or - sign
        String limit = pos ? String.valueOf(max) : String.valueOf(min).substring(1);

        // Start comparing limit with sb
        for (int i = 0; i < sb.length(); ++i) {
            if (limit.charAt(i) > sb.charAt(i))
                return Integer.parseInt((pos ? "" : "-") + sb.toString());
            else if (limit.charAt(i) < sb.charAt(i) && i > 0)
                break;
        }

        return pos ? max : min;
    }
}
