/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 13:01
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://www.codechef.com/FEB21C/problems/MAXFUN
 */

package practice.codechef.FEB21C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MAXFUN {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int min = -1, max = -1, i = 0;
            long[] nums = new long[n];

            // Find min,max indices and populate array
            while (tokenizer.hasMoreTokens()) {
                final long num = Long.parseLong(tokenizer.nextToken());
                max = max == -1 ? i : (nums[max] < num ? i : max);
                min = min == -1 ? i : (nums[min] > num ? i : min);
                nums[i++] = num;
            }

            // Find mid index which will maximize the sum
            // |nums[min] - nums[mid]| + |nums[max] - nums[mid]|
            int mid = -1;
            long midSum = 0;
            for (i = 0; i < nums.length; ++i) {
                if (i != max && i != min) {
                    final long currSum = Math.abs(nums[min] - nums[i]) + Math.abs(nums[max] -  nums[i]);
                    if (mid == -1 || midSum < currSum) {
                        mid = i;
                        midSum = currSum;
                    }
                }
            }

            System.out.println(Math.abs(nums[min] - nums[max]) + midSum);
        }
    }
}
