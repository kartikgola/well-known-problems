package leetcode;

import junit.framework.TestCase;

public class CoinChange2Test extends TestCase {

    public void testCoinChangeBottomUp() {
        CoinChange2 cc = new CoinChange2();
        assertEquals(1, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 1));
        assertEquals(2, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 2));
        assertEquals(3, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 3));
        assertEquals(1, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 5));
        assertEquals(2, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 4));
        assertEquals(3, cc.coinChange2BottomUp(new int[]{1, 2, 5}, 8));
    }
}