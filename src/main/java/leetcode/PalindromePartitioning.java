/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

    Map<Integer, List<List<String>>> map = new HashMap<>();

    private boolean isPalindrome(StringBuilder sb) {
        int p = 0, q = sb.length() - 1;
        while ( p <= q ) {
            if ( sb.charAt(p) == sb.charAt(q) ) {
                p++;
                q--;
            } else return false;
        }
        return true;
    }

    private List<List<String>> partition(String s, int j) {
        if ( map.containsKey(j) )
            return map.get(j);

        List<List<String>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for ( int i = j; i < s.length(); ++i ) {
            sb.append(s.charAt(i));
            if ( isPalindrome(sb) ) {
                for ( List<String> remainingParts : partition(s, i + 1) ) {
                    List<String> subList = new ArrayList<>();
                    subList.add(sb.toString());
                    subList.addAll(remainingParts);
                    list.add(subList);
                }
            }
        }
        if ( list.size() == 0 ) {
            list.add(new ArrayList<>());
        }

        map.put(j, list);
        return list;
    }

    public List<List<String>> partition(String s) {
        return partition(s, 0);
    }

}
