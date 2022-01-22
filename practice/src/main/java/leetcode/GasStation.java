/*
 * Author: Kartik Gola
 * Date: 1/22/22, 7:39 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        final int n = gas.length;
        int sum = 0;
        int curr = 0;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            sum += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if (curr < 0) {
                ans = i+1;
                curr = 0;
            }
        }

        return sum < 0 ? -1 : ans;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        final int n = gas.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;

        for (int i = 0; i < n; ++i) {
            sum += (gas[i] - cost[i]);
            if (sum < min) {
                min = sum;
                j = i;
            }
        }

        if (sum < 0)
            return -1;

        return (j+1) % n; // <- j is the sum run of minimum value. So, if the answer exists, it must start just after j
    }
}
