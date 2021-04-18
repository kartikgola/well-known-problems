/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package algorithms;

import java.io.IOException;

import algorithms.string.RabinKarpStringMatching;
import junit.framework.TestCase;

public class RabinKarpStringMatchingTest extends TestCase {

    public void testSolve() throws IOException {
        RabinKarpStringMatching rk = new RabinKarpStringMatching();
        assertEquals("ababcaababcaabc".indexOf("ababcaabc") >= 0, rk.solve("ababcaababcaabc", "ababcaabc"));
    }
}