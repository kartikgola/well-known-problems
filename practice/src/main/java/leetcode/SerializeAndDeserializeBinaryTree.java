/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if ( root == null )
            return "null";
        String sb = root.val +
                "," +
                serialize(root.left) +
                "," +
                serialize(root.right);
        return sb;
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
