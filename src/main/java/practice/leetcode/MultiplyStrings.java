/*
 * Author: Kartik Gola
 * Date: 11/7/21, 7:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        List<String> al = new ArrayList<>();
        int max = 0;
        for (int i = num1.length()-1; i >= 0; --i) {
            int x = Character.getNumericValue(num1.charAt(i));
            int carry = 0;
            StringBuilder sb = new StringBuilder("0".repeat(num1.length()-1-i));
            for (int j = num2.length()-1; j >= 0; --j) {
                int y = Character.getNumericValue(num2.charAt(j));
                int p = x*y+carry;
                sb.append(p % 10);
                carry = p / 10;
            }
            if (carry > 0)
                sb.append(carry);
            al.add(sb.toString());
            max = Math.max(max, sb.length());
        }

        int carry = 0;
        for (int j = 0; j < max; ++j) {
            int sum = carry;
            for (int i = 0; i < al.size(); ++i) {
                sum += j < al.get(i).length() ? Character.getNumericValue(al.get(i).charAt(j)) : 0;
            }
            ans.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0)
            ans.append(carry);

        if (ans.charAt(ans.length()-1) == '0')
            return "0";
        return ans.reverse().toString();
    }
}
