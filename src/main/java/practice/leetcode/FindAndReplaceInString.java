/*
 * Author: Kartik Gola
 * Date: 9/12/21, 12:00 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {

    private boolean match(String s, int i, String p) {
        for (int j = 0; j < p.length() && i < s.length(); ++j, ++i) {
            if (s.charAt(i) != p.charAt(j))
                return false;
        }
        return true;
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<Pair<Integer, String[]>> al = new ArrayList<>();
        for (int i = 0; i < indices.length; ++i) {
            al.add( new Pair<>(indices[i], new String[]{sources[i], targets[i]}) );
        }
        StringBuilder ans = new StringBuilder();
        al.sort(Comparator.comparingInt(Pair::getKey));
        int p = 0;
        for (int i = 0; i < al.size(); ++i) {
            int j = al.get(i).getKey();
            String pa = al.get(i).getValue()[0];
            String r = al.get(i).getValue()[1];
            while (p < j) {
                ans.append(s.charAt(p++));
            }
            if (match(s, j, pa)) {
                ans.append(r);
                p = j + pa.length();
            }
        }
        while (p < s.length())
            ans.append(s.charAt(p++));

        return ans.toString();
    }
}
