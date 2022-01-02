/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    // Represents a rectangle range where
    // row indices are in [r1, r2)
    // column indices are in [c1, c2)
    class Range {
        int r1, r2;
        int c1, c2;

        Range(int r1, int r2, int c1, int c2) {
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
        }

        int size() {
            return (r2-r1) * (c2-c1);
        }

        Range topLeft() {
            return new Range(
                    r1, (r1+r2)/2,
                    c1, (c1+c2)/2
            );
        }

        Range topRight() {
            return new Range(
                    r1, (r1+r2)/2,
                    (c1+c2)/2, c2
            );
        }

        Range bottomLeft() {
            return new Range(
                    (r1+r2)/2, r2,
                    c1, (c1+c2)/2
            );
        }

        Range bottomRight() {
            return new Range(
                    (r1+r2)/2, r2,
                    (c1+c2)/2, c2
            );
        }

        public String toString() {
            return String.format("r1=%d r2=%d c1=%d c2=%d", r1, r2, c1, c2);
        }
    }

    private Node create(int[][] grid, Range r) {
        int sum = 0;
        boolean foundZero = false;
        boolean foundOne = false;
        for (int i = r.r1; i < r.r2; ++i) {
            for (int j = r.c1; j < r.c2; ++j) {
                if (foundOne && foundZero)
                    return new Node(false, false);
                sum += grid[i][j];
                foundOne |= grid[i][j] == 1;
                foundZero |= grid[i][j] == 0;
            }
        }
        return new Node(sum == r.size(), true);
    }

    // recursively constructs the tree with given range
    private Node construct(int[][] grid, Range r) {
        Node node = create(grid, r);
        if (node.isLeaf)
            return node;

        node.topLeft = construct(grid, r.topLeft());
        node.topRight = construct(grid, r.topRight());
        node.bottomLeft = construct(grid, r.bottomLeft());
        node.bottomRight = construct(grid, r.bottomRight());
        return node;
    }

    public Node construct(int[][] grid) {
        return construct(grid, new Range(0, grid.length, 0, grid[0].length));
    }



    // Slightly more complicated solution using prefix-sum
    // which avoids summing a range multiple times
    private int sumOf(int[][] prefixSum, Range r) {
        int sum = prefixSum[r.r2-1][r.c2-1];
        if (r.r1-1 >= 0)
            sum -= prefixSum[r.r1-1][r.c2-1];
        if (r.c1-1 >= 0)
            sum -= prefixSum[r.r2-1][r.c1-1];
        if (r.r1-1 >= 0 && r.c1-1 >= 0)
            sum += prefixSum[r.r1-1][r.c1-1];
        return sum;
    }

    private Node create2(int[][] prefixSum, Range r) {
        int sum = sumOf(prefixSum, r);
        boolean isLeaf = sum == 0 || sum == r.size();
        boolean val = isLeaf && sum == r.size();
        return new Node(val, isLeaf);
    }

    private Node construct2(int[][] prefixSum, Range r) {
        Node node = create(prefixSum, r);
        if (node.isLeaf)
            return node;

        node.topLeft = construct(prefixSum, r.topLeft());
        node.topRight = construct(prefixSum, r.topRight());
        node.bottomLeft = construct(prefixSum, r.bottomLeft());
        node.bottomRight = construct(prefixSum, r.bottomRight());
        return node;
    }

    private int[][] prefixSum(int[][] grid) {
        int[][] sums = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                sums[i][j] += grid[i][j];
                if (i-1 >= 0)
                    sums[i][j] += sums[i-1][j];
                if (j-1 >= 0)
                    sums[i][j] += sums[i][j-1];
                if (i-1 >= 0 && j-1 >= 0)
                    sums[i][j] -= sums[i-1][j-1];
            }
        }
        return sums;
    }

    public Node construct2(int[][] grid) {
        return construct(prefixSum(grid), new Range(0, grid.length, 0, grid[0].length));
    }



    // O(n^2) solution that avoids processing a cell more than once
    private Node construct3(int[][] grid, Range r) {
        if (r.size() == 1)
            return new Node(grid[r.r1][r.c1] == 1, true);

        Node node = new Node();
        Node topLeft = construct3(grid, r.topLeft());
        Node topRight = construct3(grid, r.topRight());
        Node bottomLeft = construct3(grid, r.topRight());
        Node bottomRight = construct3(grid, r.bottomRight());

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
        && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            node.isLeaf = true;
            node.val = topLeft.val;
            return node;
        }

        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
        return node;
    }

    public Node construct3(int[][] grid) {
        return construct(grid, new Range(0, grid.length, 0, grid[0].length));
    }
}
