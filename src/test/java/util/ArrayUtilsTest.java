/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 14:17
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package util;

import junit.framework.TestCase;

import java.util.Arrays;

public class ArrayUtilsTest extends TestCase {

    public void testTopK() {
        System.out.println(
                Arrays.toString(ArrayUtils.minKIndices(new int[]{0,1,-1,-10,5,2,10,0,0,-1,6}, 3))
        );
    }
}