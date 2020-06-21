/*
 * Author: Kartik Gola
 * Date: 20/06/20, 2:39 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import junit.framework.TestCase;

public class TreasureIsland2Test extends TestCase {

    public void testTreasureIsland2() {

        TreasureIsland2 ti2 = new TreasureIsland2();
        char[][] t = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}
        };

        assertEquals(3, ti2.treasureIsland2(t));
    }
}