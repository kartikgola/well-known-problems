/*
 * Author: Kartik Gola
 * Date: 1/5/22, 11:43 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RabinKarpStringMatchingTest {

    @Test
    void findMatchesTest() {
        RabinKarpStringMatching rk = new RabinKarpStringMatching();
        assertEquals(Arrays.asList(1, 4), rk.findMatches("abcabcab", "bcab"));
    }

    @Test
    void findMatchesTest2() {
        RabinKarpStringMatching rk = new RabinKarpStringMatching();
        assertEquals(Collections.emptyList(), rk.findMatches("", ""));
    }

    @Test
    void findMatchesTest3() {
        RabinKarpStringMatching rk = new RabinKarpStringMatching();
        assertEquals(Arrays.asList(0,1,2,3), rk.findMatches("abcd", ""));
    }
}