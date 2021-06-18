/*
 * Author: Kartik Gola
 * Date: 9/5/20, 4:10 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if ( root1 != null ) s1.push(root1);
        if ( root2 != null ) s2.push(root2);

        boolean canGoLeft1 = true,
                canGoLeft2 = true;
        while ( !s1.isEmpty() || !s2.isEmpty() ) {
            while ( !s1.isEmpty() && canGoLeft1 && s1.peek().left != null )
                s1.push(s1.peek().left);
            while ( !s2.isEmpty() && canGoLeft2 && s2.peek().left != null )
                s2.push(s2.peek().left);

            if ( !s1.isEmpty() && ( s2.isEmpty() || s1.peek().val <= s2.peek().val) ) {
                TreeNode r1 = s1.pop();
                ans.add(r1.val);
                if ( r1.right != null ) {
                    s1.push(r1.right);
                    canGoLeft1 = true;
                } else {
                    canGoLeft1 = false;
                }
            } else if ( !s2.isEmpty() && (s1.isEmpty() || s1.peek().val > s2.peek().val) ) {
                TreeNode r2 = s2.pop();
                ans.add(r2.val);
                if ( r2.right != null ) {
                    s2.push(r2.right);
                    canGoLeft2 = true;
                } else {
                    canGoLeft2 = false;
                }
            }
        }

        return ans;
    }
}
