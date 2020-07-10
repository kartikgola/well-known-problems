/*
 * Author: Kartik Gola
 * Date: 24/06/20, 7:04 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

public class WordBreakTest extends TestCase {

    public void testWordBreak() {
        assertEquals(true, new WordBreak().wordBreak2(
                "catsdip",
                Arrays.asList("cats", "cat", "dip")
        ));
    }
}