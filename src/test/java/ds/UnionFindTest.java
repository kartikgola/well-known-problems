/*
 * Author: Kartik Gola
 * Date: 2/16/21, 10:14 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds;

import junit.framework.TestCase;

public class UnionFindTest extends TestCase {

    private UnionFind uf = new UnionFind(10);

    public void testGetNoUnionsCount() {
    }

    public void testFind() {
    }

    public void testUnion() {
        uf.union(0, 1);
        uf.union(1, 2);

        uf.union(5, 6);
        uf.union(5, 7);
        uf.union(5, 8);

        uf.union(0, 5);
        uf.union(1, 3);
    }
}