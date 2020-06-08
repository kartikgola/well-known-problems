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