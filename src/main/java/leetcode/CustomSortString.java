/*
 * Author: Kartik Gola
 * Date: 7/15/21, 9:20 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomSortString {

    public String customSortString(String order, String str) {
        List<Character> al = new ArrayList<>(str.length());
        for (char ch: str.toCharArray())
            al.add(ch);

        int[] map = new int[26];
        for (int i = 0; i < order.length(); ++i)
            map[order.charAt(i)-'a'] = -(i+1);

        al.sort(Comparator.comparingInt(a -> map[a - 'a']));

        StringBuilder sb = new StringBuilder(str.length());
        for (char ch: al)
            sb.append(ch);

        return sb.toString();
    }
}
