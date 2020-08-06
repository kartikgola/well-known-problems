/*
 * Author: Kartik Gola
 * Date: 29/06/20, 1:44 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import ds.TreeNode;

import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if ( root == null )
            return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    private TreeNode make(StringTokenizer st) {
        String tkn = st.nextToken();
        if ( tkn.equals("null") )
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(tkn));
        root.left = make(st);
        root.right = make(st);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data, ",");
        return make(st);
    }
}
