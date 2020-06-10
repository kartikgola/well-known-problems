/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package foobar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class BombBabyTest {

    @Test
    void solution() {
        String[][] test = new String[][]{
                {"0", "0"},
                {"1", "1"},
                {"1", "0"},
                {"0", "1"},
                {"5", "5"},
                {"5", "10"},
                {"10", "5"},
                {"4", "7"},
                {"1234567890123456789012345678901234567890", "12345678901234567890123456789012345678901234567890"}
        };

        String[] exp = new String[]{
                "impossible",
                "0",
                "impossible",
                "impossible",
                "impossible",
                "impossible",
                "impossible",
                "4",
                "impossible"
        };

        for ( int i = 0; i < test.length; ++i ) {
            assertEquals(exp[i], BombBaby.solution(test[i][0], test[i][1]));
        }

    }
}