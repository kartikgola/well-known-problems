/*
 * Author: Kartik Gola
 * Date: 24/07/20, 5:48 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package geeksforgeeks;

import ds.tree.binary.TreeNode;
import junit.framework.TestCase;

public class HeightOfBinaryTreeWithConnectedLeafNodesTest extends TestCase {

    public void testHeight() {
        HeightOfBinaryTreeWithConnectedLeafNodes ht = new HeightOfBinaryTreeWithConnectedLeafNodes();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r4.left = r6;

        // Connect the leaf nodes as DLL
        r6.left = r3;
        r3.right = r6;
        r6.right = r5;
        r5.left = r6;
        r3.left = r5;
        r5.right = r3;

        assertEquals(4, ht.height(r1));
    }
}