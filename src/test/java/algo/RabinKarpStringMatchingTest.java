/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package algo;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class RabinKarpStringMatchingTest {

    @Test
    void solve() throws IOException {
        RabinKarpStringMatching rk = new RabinKarpStringMatching();
        assertEquals(true, rk.solve("abcdefgh", "cdc"));
    }
}