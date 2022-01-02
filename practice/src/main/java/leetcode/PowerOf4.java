/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PowerOf4 {

    public boolean isPowerOfFour(int num) {
        return num > 0
                // Should be power of 2
                && (num & (num - 1)) == 0
                // Should have a '1' placed at any even position like 0, 2, 4, etc.
                && (num & 0x55555555) != 0;
    }

}
