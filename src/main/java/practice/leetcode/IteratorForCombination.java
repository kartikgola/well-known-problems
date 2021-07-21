/*
 * Author: Kartik Gola
 * Date: 8/16/20 7:29 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/iterator-for-combination/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorForCombination {

    private int k;
    private String str;
    private List<String> list;
    private Iterator<String> it;

    private List<String> combinations(int offset, int k) {
        List<String> ans = new ArrayList<>();
        if ( k == 1 ) {
            for ( int i = offset; i < str.length(); ++i ) {
                ans.add(Character.toString(str.charAt(i)));
            }
            return ans;
        }
        for ( int i = offset; i <= str.length() - k; ++i ) {
            List<String> subAns = combinations(i + 1, k - 1);
            for ( String sub : subAns ) {
                ans.add(str.charAt(i) + sub);
            }
        }
        return ans;
    }

    // TODO - Improvise this solution with stack approach
    public IteratorForCombination(String characters, int combinationLength) {
        this.str = characters;
        this.k = combinationLength;
        this.list = combinations(0, k);
        this.it = list.iterator();
    }

    public String next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}
