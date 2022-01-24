/*
 * Author: Kartik Gola
 * Date: 1/23/22, 1:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int MIN_LEN = (int)(Math.log(low) / Math.log(10)) + 1;
        int MAX_LEN = (int)(Math.log(high) / Math.log(10)) + 1;

        for (int len = MIN_LEN; len <= MAX_LEN; ++len) {
            for (int start = 1; start <= 10-len; ++start) {
                int curr = start;
                int num = 0;
                // Example, if len = 4
                // Start forming the number like 1000 + 200 + 30 + 4 = 1234
                for (int k = len; k > 0; --k) {
                    num += curr * (int)Math.pow(10, k-1);
                    curr++;
                }
                if (num > high)
                    return ans;
                else if (num >= low)
                    ans.add(num);
            }
        }
        return ans;
    }
}
