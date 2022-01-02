/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class SingleNumber3 {

    // O(n) time and O(1) space solution
    // Explanation - https://leetcode.com/problems/single-number-iii/solution/
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num: nums)
            mask ^= num;

        // Bit-hack to get the right-most 1-bit mask
        int rightMostBit = mask & (-mask);

        int xMask = 0;
        for (int num: nums) {
            // XOR only those num, which have 1-bit at same place as in 'rmostMask'
            if ((rightMostBit & num) != 0)
                xMask ^= num;
        }

        return new int[]{xMask, xMask^mask};
    }
}
