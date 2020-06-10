/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import junit.framework.TestCase;

public class CoinChangeTest extends TestCase {

    public void testCoinChangeTopDown() {
    }

    public void testCoinChangeBottomUp() {
        CoinChange cc = new CoinChange();
        assertEquals(2, cc.coinChangeBottomUp(new int[]{1, 2, 5}, 6));
        assertEquals(1, cc.coinChangeBottomUp(new int[]{1, 2, 5}, 5));
        assertEquals(2, cc.coinChangeBottomUp(new int[]{1, 2, 5}, 4));
        assertEquals(3, cc.coinChangeBottomUp(new int[]{1, 2, 5}, 8));
    }
}