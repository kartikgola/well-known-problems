/*
 * Author: Kartik Gola
 * Date: 24/07/20, 5:44 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected/
 */

package geeksforgeeks;

import util.ds.tree.binary.TreeNode;

public class HeightOfBinaryTreeWithConnectedLeafNodes {

    public int height(TreeNode root) {
        if ( root != null ) {
            int left = 0,
                right = 0;
            if ( root.left != null && root.left.right != root ) {
                left = height(root.left);
            }
            if ( root.right != null && root.right.left != root ) {
                right = height(root.right);
            }
            return 1 + Math.max(left, right);
        }
        return 0;
    }
}
