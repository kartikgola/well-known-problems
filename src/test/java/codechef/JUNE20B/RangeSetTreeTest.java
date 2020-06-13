/*
 * Author: Kartik Gola
 * Date: 6/13/20 8:29 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef.JUNE20B;

import junit.framework.TestCase;

public class RangeSetTreeTest extends TestCase {

    public void test() {
        RangeSetTree rst = new RangeSetTree(3 * 3);
        rst.update(0, 0, 8, 0, 8, 1);
        rst.update(0, 0, 8, 0, 4, 0);
        rst.update(0, 0, 8, 5, 6, 0);
    }
}