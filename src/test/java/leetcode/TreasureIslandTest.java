/*
 * Author: Kartik Gola
 * Date: 20/06/20, 12:14 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import junit.framework.TestCase;

public class TreasureIslandTest extends TestCase {

    public void testTreasureIsland() {

        TreasureIsland ti = new TreasureIsland();
        char[][] t = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'O', 'D', 'D', 'X'}
        };
        assertEquals(6, ti.treasureIslandBFS(t));

        char[][] t2 = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        assertEquals(5, ti.treasureIslandBFS(t2));
    }
}