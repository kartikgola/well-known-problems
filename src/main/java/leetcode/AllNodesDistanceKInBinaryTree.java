/*
 * Author: Kartik Gola
 * Date: 23/06/20, 11:54 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    private void updateParent(TreeNode root, TreeNode parent) {
        if ( root != null ) {
            map.put(root, parent);
            updateParent(root.left, root);
            updateParent(root.right, root);
        }
    }

    // BFS Solution
    // Time: O(n), Space: O(n)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        updateParent(root, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        q.add(null);

        int dist = 0;
        while ( !q.isEmpty() && dist <= K ) {
            TreeNode p = q.poll();

            if ( p == null ) {
                if ( q.isEmpty() ) {
                    break;
                } else {
                    q.add(null);
                    ++dist;
                }
            } else {
                visited.put(p, true);
                if ( dist == K )
                    res.add(p.val);

                if ( p.left != null && !visited.getOrDefault(p.left, false) )
                    q.add( p.left );

                if ( p.right != null && !visited.getOrDefault(p.right, false) )
                    q.add( p.right );

                if ( map.get(p) != null && !visited.getOrDefault(map.get(p), false) )
                    q.add( map.get(p) );
            }
        }

        return res;
    }

    // DFS Solution
    // Time: O(n), Space: O(n)
    private void distanceK2(TreeNode root, Map<TreeNode, Boolean> visit, int dist, int k) {
        if ( root != null ) {
            visit.putIfAbsent(root, true);
            if ( dist == k ) {
                res.add(root.val);
            } else if ( dist < k ) {
                if ( root.left != null && !visit.getOrDefault(root.left, false) )
                    distanceK2(root.left, visit, 1 + dist, k);

                if ( root.right != null && !visit.getOrDefault(root.left, false) )
                    distanceK2(root.right, visit, 1 + dist, k);

                if ( map.get(root) != null && !visit.getOrDefault(map.get(root), false) )
                    distanceK2(map.get(root), visit, 1 + dist, k);
            }
        }
    }

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        updateParent(root, target);
        distanceK2(target, new HashMap<>(),0, K);
        return res;
    }
}
