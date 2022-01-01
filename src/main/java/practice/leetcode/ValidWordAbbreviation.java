/*
 * Author: Kartik Gola
 * Date: 1/1/22, 10:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int i = 0;
        StringBuilder digit = new StringBuilder();
        for (; i < abbr.length(); ++i) {
            if (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                if ((digit.length() == 0) && abbr.charAt(i) == '0')
                    return false;
                digit.append(abbr.charAt(i));
            } else {
                if (digit.length() > 0) {
                    j += Integer.parseInt(digit.toString());
                    digit = new StringBuilder();
                }
                if (j >= word.length())
                    return false;
                if (word.charAt(j) != abbr.charAt(i))
                    return false;
                j++;
            }
        }

        if (digit.length() > 0) {
            j += Integer.parseInt(digit.toString());
        }

        return j == word.length() && i == abbr.length();
    }
}
