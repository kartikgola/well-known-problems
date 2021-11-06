/*
 * Author: Kartik Gola
 * Date: 10/17/21, 11:15 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class SmallestRectangleEnclosingBlackPixels {

    public int minArea(char[][] image, int x, int y) {
        final int m = image.length;
        final int n = image[0].length;

        int y1 = searchCol(image, 0, y, 0, m-1, true);
        int y2 = searchCol(image, y+1, n, 0, m-1, false);

        int x1 = searchRow(image, 0, x, 0, n-1, true);
        int x2 = searchRow(image, x+1, m, 0, n-1, false);

        return (y2-y1) * (x2-x1);
    }

    private int searchCol(char[][] arr, int l, int r, int top, int bottom, boolean leftMost) {
        while (l < r) {
            int m = l+(r-l)/2;
            int k = top;
            while (k <= bottom && arr[k][m] == '0')
                ++k;
            if (leftMost) {
                if (k <= bottom) {
                    r = m;
                } else {
                    l = m+1;
                }
            } else {
                if (k <= bottom) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
        }
        return l;
    }

    private int searchRow(char[][] arr, int l, int r, int left, int right, boolean bottomMost) {
        while (l < r) {
            int m = l+(r-l)/2;
            int k = left;
            while (k <= right && arr[m][k] == '0')
                ++k;
            if (bottomMost) {
                if (k <= right) {
                    r = m;
                } else {
                    l = m+1;
                }
            } else {
                if (k <= right) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
        }
        return l;
    }
}
