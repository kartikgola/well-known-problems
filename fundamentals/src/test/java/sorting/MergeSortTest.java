/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package sorting;

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