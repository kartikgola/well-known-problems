/*
 * Author: Kartik Gola
 * Date: 10/7/21, 11:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if ( N % 2 == 0 )
            return list;
        if ( N == 1 ) {
            list.add(new TreeNode(0));
        } else if ( N >= 3 ) {
            // 7 => (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
            for ( int left = 1; left < N - 1; ++left ) {
                List<TreeNode> leftList = allPossibleFBT(left);
                List<TreeNode> rightList = allPossibleFBT(N - 1 - left);
                for ( TreeNode tnLeft : leftList ) {
                    for ( TreeNode tnRight : rightList ) {
                        TreeNode root = new TreeNode(0);
                        root.left = tnLeft;
                        root.right = tnRight;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
