/*
 * Author: Kartik Gola
 * Date: 7/18/20 9:33 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds.tree.binary;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}