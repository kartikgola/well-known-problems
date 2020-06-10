/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import junit.framework.TestCase;

public class PowerOfTwoTest extends TestCase {

    public void testIsPowerOfTwoBitHack() {
        PowerOfTwo pot = new PowerOfTwo();
        assertTrue(pot.isPowerOfTwoBitHack(1));
        assertTrue(pot.isPowerOfTwoBitHack(2));
        assertTrue(pot.isPowerOfTwoBitHack(4));
        assertTrue(pot.isPowerOfTwoBitHack(8));
        assertFalse(pot.isPowerOfTwoBitHack(0));
        assertFalse(pot.isPowerOfTwoBitHack(3));
        assertFalse(pot.isPowerOfTwoBitHack(5));
        assertFalse(pot.isPowerOfTwoBitHack(7));
    }

    public void testIsPowerOfTwoNaive() {
        PowerOfTwo pot = new PowerOfTwo();
        assertTrue(pot.isPowerOfTwoNaive(1));
        assertTrue(pot.isPowerOfTwoNaive(2));
        assertTrue(pot.isPowerOfTwoNaive(4));
        assertTrue(pot.isPowerOfTwoNaive(8));
        assertFalse(pot.isPowerOfTwoNaive(0));
        assertFalse(pot.isPowerOfTwoNaive(3));
        assertFalse(pot.isPowerOfTwoNaive(5));
        assertFalse(pot.isPowerOfTwoNaive(7));
    }
}