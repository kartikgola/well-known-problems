/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class DiagonalSum {

    Map<Integer, Integer> map = new HashMap<>();

    static class Node {
        Node left, right;
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    private void dSum(Node root, int depth, int key) {
        if ( root != null ) {
            if ( !map.containsKey(key) )
                map.put(key, root.val);
            else
                map.put(key, map.get(key) + root.val);
            dSum(root.right, depth + 1, key);
            dSum(root.left, depth + 1, key + 1);
        }
    }

    public void solve() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(7);
        root.left.right.left = new Node(11);
        root.left.left.right = new Node(10);
        dSum(root, 0, 0);
        System.out.println(map);
    }
}
