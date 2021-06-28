/*
 * Author: Kartik Gola
 * Date: 6/27/21, 1:12 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        MergeSort ms = new MergeSort();
        int[] tc = new int[]{30, 20, 10, 50, 40};
        ms.sort(tc);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, tc);
    }
}