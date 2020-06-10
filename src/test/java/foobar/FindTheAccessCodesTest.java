/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package foobar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class FindTheAccessCodesTest {

    @Test
    void solution() {
        int[] t1 = new int[]{1,2,3,4,5,6,7,8};
        int r1 = FindTheAccessCodes.solution(t1);
        assertEquals(6, r1);

        int[] t2 = new int[]{1,2,3,4,5,6};
        int r2 = FindTheAccessCodes.solution(t2);
        assertEquals(3, r2);

        int[] t3 = new int[]{1,2,3,4};
        int r3 = FindTheAccessCodes.solution(t3);
        assertEquals(1, r3);
    }
}