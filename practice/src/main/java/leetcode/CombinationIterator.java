/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationIterator {

    private int len;
    private String str;
    private List<String> list;
    private Iterator<String> it;

    private List<String> combinations(int offset, int len) {
        List<String> ans = new ArrayList<>();
        if (len == 0) {
            ans.add("");
            return ans;
        }
        for ( int i = offset; i <= str.length() - len; ++i ) {
            List<String> subAns = combinations(i + 1, len - 1);
            for ( String sub : subAns ) {
                ans.add(str.charAt(i) + sub);
            }
        }
        return ans;
    }

    public CombinationIterator(String characters, int combinationLength) {
        this.str = characters;
        this.len = combinationLength;
        this.list = combinations(0, len);
        this.it = list.iterator();
    }

    public String next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}
