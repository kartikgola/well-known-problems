/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.Pair;
import tree.binary.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pa = q.poll();
            TreeNode curr = pa.getKey();
            int pos = pa.getValue();

            map.putIfAbsent(pos, new ArrayList<>());
            map.get(pos).add(curr.val);

            if (curr.left != null)
                q.add(new Pair<>(curr.left, pos-1));

            if (curr.right != null)
                q.add(new Pair<>(curr.right, pos+1));
        }

        return new ArrayList<>(map.values());
    }
}
