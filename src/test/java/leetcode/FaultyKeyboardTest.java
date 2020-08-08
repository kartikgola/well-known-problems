/*
 * Author: Kartik Gola
 * Date: 8/8/20 2:20 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/discuss/interview-experience/778039/google-phone-interview-rejected
 */

package leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

public class FaultyKeyboardTest extends TestCase {

    public void testPossibleStrings() {
        FaultyKeyboard fk = new FaultyKeyboard();
        assertEquals(Arrays.asList("can serene", "canes rene"), fk.possibleStrings("can s r n ", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList(), fk.possibleStrings("can ", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList("canes"), fk.possibleStrings("can s", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList(), fk.possibleStrings("s r n", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList("serene"), fk.possibleStrings("s r n ", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList("reneserene"), fk.possibleStrings("r n s r n ", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList(), fk.possibleStrings("r n", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList("renecan serene", "renecanes rene"), fk.possibleStrings("r n can s r n ", new String[]{"can", "canes", "serene", "rene", "sam"}));
        assertEquals(Arrays.asList("cancanesserene"), fk.possibleStrings("cancanesserene", new String[]{"can", "canes", "serene", "rene", "sam"}));
    }
}