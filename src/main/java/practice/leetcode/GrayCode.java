/*
 * Author: Kartik Gola
 * Date: 7/1/21, 7:19 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/gray-code/
 */

package practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrayCode {

    // flip kth bit of a number 'n'
    private int flip(int n, int k) { return n ^ (1 << k); }

    private void grayCode(int num, int n, Map<Integer, Integer> posMap) {
        for (int i = 0; i < n; i++) {
            final int m = flip(num, i);
            if (!posMap.containsKey(m)) {
                posMap.put(m, posMap.size());
                grayCode(m, n, posMap);
            }
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ans = IntStream.range(0, (int) Math.pow(2, n)).boxed().collect(Collectors.toList());
        Map<Integer, Integer> posMap = new HashMap<>(){{ put(0, 0); }};
        grayCode(0, n, posMap);
        // At this point, you have a map like - {0=0, 3=2, 1=1, 2=3}
        // where 'key' is the number and 'value' is its position in answer [0, 1, 3, 2]
        posMap.forEach((key, value) -> ans.set(value, key));
        return ans;
    }

}
