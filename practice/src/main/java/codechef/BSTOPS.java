/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Complete this problem
// Currently fails at all test cases :(
public class BSTOPS {

    class BTree {

        class Node {
            long val;
            long pos;
            Node left = null, right = null;

            public Node(long val, long pos) {
                this.val = val;
                this.pos = pos;
            }
        }

        private Node root = null;

        private Node insertNode(Node current, long val, long pos) {
            if ( current == null ) {
                current = new Node(val, pos);
                System.out.println(current.pos);
                return current;
            } else if ( current.val < val ) {
                current.right = insertNode(current.right, val, pos * 2 + 1);
            } else if ( current.val > val ) {
                current.left = insertNode(current.left, val, pos * 2);
            }
            return current;
        }

        private Node inOrderSuccessor(Node current) {
            Node left = current.left;
            while ( left != null ) {
                Node temp = left;
                left = left.left;
                current = temp;
            }
            return current;
        }

        private Node removeNode(Node current, long val, boolean printPos) {
            if ( current == null )
                return null;
            if ( current.val < val ) {
                current.right = removeNode(current.right, val, printPos);
            } else if ( current.val > val ) {
                current.left = removeNode(current.left, val, printPos);
            } else {
                if ( printPos ) System.out.println( current.pos );
                if ( current.left == null ) {
                    return current.right;
                } else if ( current.right == null ) {
                    return current.left;
                } else {
                    Node nextMinNode = inOrderSuccessor(current.right);
                    current.val = nextMinNode.val;
                    current.right = removeNode(current.right, nextMinNode.val, false);
                }
            }
            return current;
        }

        void add(long val) {
            root = insertNode(root, val, 1);
        }

        void remove(long val) {
            root = removeNode(root, val, true);
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        BTree bTree = new BTree();
        StringTokenizer tokenizer;

        while ( n-- > 0 ) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            String operation = tokenizer.nextToken();
            long val = Long.parseLong(tokenizer.nextToken());

            if ( operation.equals("i") )
                bTree.add(val);
            else
                bTree.remove(val);
        }
    }
}
