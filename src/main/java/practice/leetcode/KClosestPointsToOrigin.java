/*
 * Author: Kartik Gola
 * Date: 12/13/21, 5:07 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Random;

public class KClosestPointsToOrigin {

    private final Random random = new Random();

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private int partition(int[][] points, int lo, int hi, int p) {
        int[] pivot = points[p];
        swap(points, p, hi);
        int i = lo;
        for (int j = lo; j <= hi; ++j) {
            if (dist(points[j]) < dist(pivot)) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, hi);
        return i;
    }

    private int quickSelect(int[][] points, int lo, int hi, int k) {
        if (lo < hi) {
            int rand = lo + random.nextInt(hi - lo);
            int p = partition(points, lo, hi, rand);
            if (p == k)
                return p;
            else if (p < k)
                return quickSelect(points, p+1, hi, k);
            else
                return quickSelect(points, lo, p-1, k);
        } else return lo;
    }

    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length-1, k-1);
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; ++i)
            ans[i] = points[i];
        return ans;
    }
}
