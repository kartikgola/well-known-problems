/*
 * Author: Kartik Gola
 * Date: 11/30/21, 12:16 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    private int ptr = 1;
    private String[] arr;

    public OrderedStream(int n) {
        this.arr = new String[n+1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        arr[idKey] = value;
        while (ptr < arr.length && arr[ptr] != null)
            ans.add(arr[ptr++]);
        return ans;
    }
}
