/*
 * Author: Kartik Gola
 * Date: 06/07/20, 1:40 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ctci.chapter5;

import junit.framework.TestCase;

public class FlipBitToWinTest extends TestCase {

    public void testFlipBitToWin() {
        FlipBitToWin f = new FlipBitToWin();
        assertEquals(8, f.flipBitToWin(1775));
        assertEquals(31, f.flipBitToWin(Integer.MAX_VALUE));
    }
}