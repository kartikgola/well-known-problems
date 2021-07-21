/*
 * Author: Kartik Gola
 * Date: 07/10/2020, 22:53
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/add-strings/
 */

package practice.leetcode;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1,
                j = num2.length() - 1;

        int carry = 0, sum = 0;
        while ( i > -1 || j > -1 ) {
            sum = carry;
            if ( i > -1 )
                sum += Character.getNumericValue(num1.charAt(i--));
            if ( j > -1 )
                sum += Character.getNumericValue(num2.charAt(j--));
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }

        if ( carry > 0 )
            sb.append(carry);

        return sb.reverse().toString();
    }
}
