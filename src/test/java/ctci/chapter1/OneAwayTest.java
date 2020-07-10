/*
 * Author: Kartik Gola
 * Date: 25/06/20, 11:30 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package ctci.chapter1;

import junit.framework.TestCase;

public class OneAwayTest extends TestCase {

    public void testOneAway() {
        OneAway oa = new OneAway();
        assertEquals(true, oa.oneAway("dale", "bale"));
        assertEquals(false, oa.oneAway("donk", "donkes"));
        assertEquals(true, oa.oneAway("", "a"));
        assertEquals(false, oa.oneAway("cake", "bakes"));
        assertEquals(true, oa.oneAway("lake", "lakes"));

        assertEquals(true, oa.oneAway("123", "1234"));
        assertEquals(false, oa.oneAway("1232", "1223"));
        assertEquals(true, oa.oneAway("1111", "111"));
        assertEquals(false, oa.oneAway("1122", "121"));
        assertEquals(true, oa.oneAway("1", "21"));

        assertEquals(true, oa.oneAway("dale", "dape"));
        assertEquals(false, oa.oneAway("dale", "gape"));
        assertEquals(true, oa.oneAway("", "a"));
        assertEquals(false, oa.oneAway("", "ab"));
        assertEquals(true, oa.oneAway("cake", "cace"));
        assertEquals(true, oa.oneAway("dale", "ale"));
        assertEquals(true, oa.oneAway("deap", "deep"));
        assertEquals(true, oa.oneAway("adeep", "deep"));
        assertEquals(true, oa.oneAway("111", "1111"));
    }
}