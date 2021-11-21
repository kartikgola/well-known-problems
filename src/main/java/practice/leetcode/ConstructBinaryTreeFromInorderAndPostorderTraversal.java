/*
 * Author: Kartik Gola
 * Date: 11/21/21, 6:12 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private Map<Integer, Integer> map = new HashMap<>();

    private TreeNode f(int[] inorder, int[] postorder, int i, int j, int k, int l) {
        if (i > j || k > l)
            return null;

        TreeNode root = new TreeNode(postorder[l]);
        int x = map.get(postorder[l]);
        int countLeft = x - i;
        int countRight = j - x;

        root.left = f(inorder, postorder, i, i+countLeft-1, k, k+countLeft-1);
        root.right = f(inorder, postorder, i+countLeft+1, i+countLeft+countRight, k+countLeft, k+countLeft+countRight-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return f(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}
