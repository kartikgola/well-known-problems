/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:01 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import junit.framework.TestCase;

public class CountPrimesTest extends TestCase {

    public void testCountPrimes() {
        CountPrimes cp = new CountPrimes();
        cp.countPrimes(1000_000);
    }
}