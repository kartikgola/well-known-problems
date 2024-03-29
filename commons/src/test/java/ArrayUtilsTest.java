/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:41 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static util.ArrayUtils.Bisect.bisectLeft;
import static util.ArrayUtils.Bisect.bisectRight;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void testBisectLeft() {
        assertEquals(2, bisectLeft(new int[]{10, 20, 30, 40, 50}, 25));
        assertEquals(0, bisectLeft(new int[]{10, 10, 10, 10, 10}, 10));
        assertEquals(2, bisectLeft(new int[]{10, 10, 20, 20, 20}, 20));
        assertEquals(1, bisectLeft(new int[]{10, 20, 20, 20, 30}, 20));
        assertEquals(4, bisectLeft(new int[]{10, 20, 20, 20}, 30));
        assertEquals(1, bisectLeft(new int[]{10, 20, 20, 50}, 20));
        assertEquals(0, bisectLeft(new int[]{10, 10, 10, 10}, 10));
        assertEquals(4, bisectLeft(new int[]{10, 10, 10, 10}, 20));
        assertEquals(0, bisectLeft(new int[]{10}, 10));
        assertEquals(1, bisectLeft(new int[]{10}, 20));
        assertEquals(0, bisectLeft(new int[]{}, 20));
        assertEquals(1, bisectLeft(new int[]{10, 20}, 20));

        assertEquals(2, bisectLeft(Arrays.asList(10, 20, 30, 40, 50), 25));
        assertEquals(0, bisectLeft(Arrays.asList(10, 10, 10, 10, 10), 10));
        assertEquals(2, bisectLeft(Arrays.asList(10, 10, 20, 20, 20), 20));
        assertEquals(1, bisectLeft(Arrays.asList(10, 20, 20, 20, 30), 20));
        assertEquals(4, bisectLeft(Arrays.asList(10, 20, 20, 20), 30));
        assertEquals(1, bisectLeft(Arrays.asList(10, 20, 20, 50), 20));
        assertEquals(0, bisectLeft(Arrays.asList(10, 10, 10, 10), 10));
        assertEquals(4, bisectLeft(Arrays.asList(10, 10, 10, 10), 20));
        assertEquals(0, bisectLeft(Arrays.asList(10), 10));
        assertEquals(1, bisectLeft(Arrays.asList(10), 20));
        assertEquals(0, bisectLeft(Arrays.asList(), 20));
    }

    @Test
    void testBisectRight() {
        assertEquals(2, bisectRight(new int[]{10, 20, 30, 40, 50}, 25));
        assertEquals(5, bisectRight(new int[]{10, 10, 10, 10, 10}, 10));
        assertEquals(5, bisectRight(new int[]{10, 10, 20, 20, 20}, 20));
        assertEquals(4, bisectRight(new int[]{10, 20, 20, 20, 30}, 20));
        assertEquals(4, bisectRight(new int[]{10, 20, 20, 20}, 30));
        assertEquals(3, bisectRight(new int[]{10, 20, 20, 50}, 20));
        assertEquals(1, bisectRight(new int[]{10}, 10));
        assertEquals(1, bisectRight(new int[]{10}, 20));
        assertEquals(0, bisectRight(new int[]{10}, 5));
        assertEquals(1, bisectRight(new int[]{10, 20}, 19));

        assertEquals(2, bisectRight(Arrays.asList(10, 20, 30, 40, 50), 25));
        assertEquals(5, bisectRight(Arrays.asList(10, 10, 10, 10, 10), 10));
        assertEquals(5, bisectRight(Arrays.asList(10, 10, 20, 20, 20), 20));
        assertEquals(4, bisectRight(Arrays.asList(10, 20, 20, 20, 30), 20));
        assertEquals(4, bisectRight(Arrays.asList(10, 20, 20, 20), 30));
        assertEquals(3, bisectRight(Arrays.asList(10, 20, 20, 50), 20));
        assertEquals(1, bisectRight(Arrays.asList(10), 10));
        assertEquals(1, bisectRight(Arrays.asList(10), 20));
        assertEquals(0, bisectRight(Arrays.asList(10), 5));
    }

}