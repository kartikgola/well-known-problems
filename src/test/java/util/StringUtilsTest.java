package util;

import javafx.util.Pair;
import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

public class StringUtilsTest extends TestCase {

    public void testSuffixArray() {
        List<Pair<String, int[]>> testCases = Arrays.asList(
            new Pair<>("ababba", new int[]{6, 5, 2, 0, 1, 4, 3}),
            new Pair<>("", new int[]{0})
        );

        for (Pair<String, int[]> tc: testCases) {
            assertArrayEquals(tc.getValue(), StringUtils.suffixArray(tc.getKey()));
        }
    }
}