/*
 * Author: Kartik Gola
 * Date: 17/09/2020, 19:40
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package util;

import junit.framework.TestCase;

import java.util.Arrays;

public class MathUtilsTest extends TestCase {

    public void testFastPow() {
    }

    public void testPrimeNumbersUpto() {
        assertEquals(Arrays.asList(2, 3, 5, 7, 11), MathUtils.primeNumbersUpto(13));
    }

    public void testPrimeFactors() {
        assertEquals(Arrays.asList(3, 5, 5), MathUtils.primeFactors(75));
        assertEquals(Arrays.asList(3, 5, 13), MathUtils.primeFactors(195));
        assertEquals(Arrays.asList(2, 2, 3), MathUtils.primeFactors(12));
        assertEquals(Arrays.asList(), MathUtils.primeFactors(13));
    }
}