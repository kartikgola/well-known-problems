/*
 * Author: Kartik Gola
 * Date: 8/7/20 8:43 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;
import util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class VerticalOrderTraversalOfABinaryTree {

    // Every element of Queue is Pair<TreeNode, Pair<X, Y>>
    private Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new PriorityQueue<>((Pair<TreeNode, Pair<Integer, Integer>> p1, Pair<TreeNode, Pair<Integer, Integer>> p2) -> {
        int x1 = p1.getValue().getKey(),
            y1 = p1.getValue().getValue();

        int x2 = p2.getValue().getKey(),
            y2 = p2.getValue().getValue();

        // Smaller values of X should come first
        if ( x1 - x2 != 0 ) return x1 - x2;
        // Smaller values of Y should come first
        // If root is at Y=y, children will be at Y=y-1
        // So, we put root first
        if ( y2 - y1 != 0 ) return y2 - y1;
        return p1.getKey().val - p2.getKey().val;
    });

    private void verticalTraversal(TreeNode root, int x, int y) {
        if ( root != null ) {
            q.add(new Pair<>(root, new Pair<>(x, y)));
            // Scheme of calculating X & Y of a node is given in problem statement
            verticalTraversal(root.left, x - 1, y - 1);
            verticalTraversal(root.right, x + 1, y - 1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int x = Integer.MIN_VALUE;

        // Club all the elements with same X value in a temporary list
        // Then, add that temp list to answer when X value changes
        while ( !q.isEmpty() ) {
            Pair<TreeNode, Pair<Integer, Integer>> p = q.poll();
            if ( x == Integer.MIN_VALUE ) {
                x = p.getValue().getKey();
                temp.add(p.getKey().val);
            } else if ( p.getValue().getKey() == x ) {
                temp.add(p.getKey().val);
            } else {
                x = p.getValue().getKey();
                ans.add(temp);
                temp = new ArrayList<>();
                temp.add(p.getKey().val);
            }
        }

        if ( !temp.isEmpty() )
            ans.add(temp);

        return ans;
    }
}
