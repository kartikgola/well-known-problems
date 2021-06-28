/*
 * Author: Kartik Gola
 * Date: 6/8/21, 6:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheMaze2Test {

    @Test
    void shortestDistance() {
        new TheMaze2().shortestDistance(
            new int[][]{
                    {0,0,1,0,0},
                    {0,0,0,0,0},
                    {0,0,0,1,0},
                    {1,1,0,1,1},
                    {0,0,0,0,0}
            },
            new int[]{0, 4},
            new int[]{4, 4}
        );
    }
}