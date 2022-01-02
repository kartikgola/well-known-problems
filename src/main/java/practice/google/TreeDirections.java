/*
 * Author: Kartik Gola
 * Date: 9/13/21, 10:44 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.google;

import util.ds.tree.binary.TreeNode;

import java.util.StringTokenizer;

public class TreeDirections {

    static int ans = 0;

    private static int[] f(TreeNode root, int prev) {
        if (root == null)
            return new int[]{0, 0};
        final int[] left = f(root.left, root.val);
        final int[] right = f(root.right, root.val);

        int root_cd = prev - root.val;
        int left_max = left[0], right_max = right[0];
        int left_cd = left[1], right_cd = right[1];

        if (left_cd * -1 == right_cd) {
            ans = Math.max(ans, 1 + left_max + right_max);
        } else {
            ans = Math.max(ans, 1 + Math.max(left_max, right_max));
        }
        
        if (left_cd == right_cd && root_cd == left_cd) {
            return new int[]{1+Math.max(left_max, right_max), root_cd};
        } else if (root_cd == left_cd) {
            return new int[]{1 + left_max, root_cd};
        } else if (root_cd == right_cd) {
            return new int[]{1 + right_max, root_cd};
        } else {
            return new int[]{1, root_cd};
        }
    }

    public static void main(String[] args) {
        TreeNode root = make(new StringTokenizer("0,2,4,null,null,4,6,null,null,null,-2,null,-4,7,null,null,-6,null,null", ","));
        f(root, 1000_000);
        System.out.println(ans);
    }

    private static TreeNode make(StringTokenizer st) {
        String tkn = st.nextToken();
        if ( tkn.equals("null") )
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(tkn));
        root.left = make(st);
        root.right = make(st);
        return root;
    }
}
