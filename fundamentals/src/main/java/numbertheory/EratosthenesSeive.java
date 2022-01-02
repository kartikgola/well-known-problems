/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package numbertheory;

import java.util.Arrays;

public class EratosthenesSeive {

    // Returns EratosthenesSeive in [0, n]
    // Time complexity = O(nlog(log(n))
    public boolean[] solve(int n) {
        boolean[] seive = new boolean[n+1];
        Arrays.fill(seive, true);
        seive[0] = seive[1] = false;
        for (int i = 2; i*i <= n; ++i) {
            if (seive[i]) {
                for (int j = i*i; j <= n; j += i) {
                    seive[j] = false;
                }
            }
        }
        return seive;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new EratosthenesSeive().solve(20)));
    }
}
