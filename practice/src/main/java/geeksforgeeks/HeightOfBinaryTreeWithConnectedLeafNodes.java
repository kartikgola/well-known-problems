/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package geeksforgeeks;

import tree.binary.TreeNode;

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
