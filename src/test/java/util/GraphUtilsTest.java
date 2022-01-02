/*
 * Author: Kartik Gola
 * Date: 6/8/21, 6:58 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    @Test
    void topologicalSort() {
    }

    @Test
    void cutVerticesTest1() {
        GraphUtils.IntGraph ig = new GraphUtils.IntGraph(4, false, new int[][]{
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3}
        });
        assertEquals(Collections.singletonList(1), ig.cutVertices());
    }

    @Test
    void cutVerticesTest2() {
        GraphUtils.IntGraph ig = new GraphUtils.IntGraph(3, false, new int[][]{
                {0, 1},
                {0, 2},
        });
        assertEquals(Collections.singletonList(0), ig.cutVertices());
    }

    @Test
    void cutVerticesTest3() {
        GraphUtils.IntGraph ig = new GraphUtils.IntGraph(7, false, new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 3},
                {3, 0},
                {2, 6}
        });
        assertEquals(Arrays.asList(2, 3), ig.cutVertices());
    }
}