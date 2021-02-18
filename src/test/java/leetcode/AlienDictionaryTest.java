/*
 * Author: Kartik Gola
 * Date: 29/01/2021, 16:36
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import junit.framework.TestCase;

public class AlienDictionaryTest extends TestCase {

    public void testAlienOrder() {
        AlienDictionary ad = new AlienDictionary();
        ad.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        ad.alienOrder(new String[]{"ab", "a"});
    }
}