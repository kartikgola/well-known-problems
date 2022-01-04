/*
 * Author: Kartik Gola
 * Date: 1/4/22, 5:36 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        int len = (int) (Math.log(n) / Math.log(2) + 1);
        int mask = (1 << len) - 1;
        return mask ^ n;
    }
}
