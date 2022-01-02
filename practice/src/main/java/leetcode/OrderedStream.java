/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
