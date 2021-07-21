/*
 * Author: Kartik Gola
 * Date: 7/18/20 9:28 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if ( lo > hi )
            return res;
        for ( int i = lo; i <= hi; ++i ) {
            // Select 'i' as root node
            // Generate left sub-trees
            List<TreeNode> left = generateTrees(lo, i - 1);
            // Generate right sub-trees
            List<TreeNode> right = generateTrees(i + 1, hi);
            if ( left.size() > 0 && right.size() > 0 ) {
                for ( TreeNode lst : left ) {
                    for ( TreeNode rst : right ) {
                        TreeNode root = new TreeNode(i);
                        root.left = lst;
                        root.right = rst;
                        res.add(root);
                    }
                }
            } else if ( left.size() > 0 ) {
                for ( TreeNode lst : left ) {
                    TreeNode root = new TreeNode(i);
                    root.left = lst;
                    res.add(root);
                }
            } else if ( right.size() > 0 ) {
                for ( TreeNode rst : right ) {
                    TreeNode root = new TreeNode(i);
                    root.right = rst;
                    res.add(root);
                }
            } else {
                res.add(new TreeNode(i));
            }
        }
        return res;
    }
}
