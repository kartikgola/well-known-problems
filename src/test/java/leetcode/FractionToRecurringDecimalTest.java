/*
 * Author: Kartik Gola
 * Date: 28/02/2021, 19:09
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: 
 */

package leetcode;

import junit.framework.TestCase;

public class FractionToRecurringDecimalTest extends TestCase {

    public void testFractionToDecimal() {
        FractionToRecurringDecimal f2d = new FractionToRecurringDecimal();
        int[][] tests = new int[][]{
                {1, 10},
                {2, 3},
                {4, 3},
                {4, 33333},
                {1, 3},
                {22, 7},
                {50, 2},
                {1000, 5}
        };
        for (int[] t: tests) {
            System.out.println(f2d.fractionToDecimal(t[0], t[1]));
        }
    }
}