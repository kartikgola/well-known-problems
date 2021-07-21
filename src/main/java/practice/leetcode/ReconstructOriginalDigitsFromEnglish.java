/*
 * Author: Kartik Gola
 * Date: 29/03/2021, 00:19
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/reconstruct-original-digits-from-english/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        // Every number has a unique character in it
        // 'nums[i]' is a tuple of (number in english, number, unique char)
        String[][] nums = new String[][]{
            {"zero", "0", "z"},
            {"two", "2", "w"},
            {"four", "4", "u"},
            {"six", "6", "x"},
            {"eight", "8", "g"},
            {"one", "1", "o"},
            {"three", "3", "t"},
            {"five", "5", "f"},
            {"seven", "7", "v"},
            {"nine", "9", "i"}
        };

        StringBuilder[] temp = new StringBuilder[10];
        for (String[] num : nums) {
            int val = Integer.parseInt(num[1]);
            while (map.getOrDefault(num[2].charAt(0), 0) > 0) {
                for (char ch : num[0].toCharArray()) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0)
                        map.remove(ch);
                }
                if (temp[val] == null)
                    temp[val] = new StringBuilder();
                temp[val].append(val);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder t: temp)
            if (t != null)
                ans.append(t);

        return ans.toString();
    }
}
