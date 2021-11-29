/*
 * Author: Kartik Gola
 * Date: 11/30/21, 12:16 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    private int start = 0;
    private String[] values;

    public OrderedStream(int n) {
        values = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        values[idKey-1] = value;
        while (start < values.length && values[start] != null)
            ans.add(values[start++]);
        return ans;
    }
}
