/*
 * Author: Kartik Gola
 * Date: 08/07/20, 11:17 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package commons;

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