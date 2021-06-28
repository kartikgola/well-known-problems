/*
 * Author: Kartik Gola
 * Date: 03/02/2021, 08:53
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

public class SquirrelSimulation {

    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // Calculate the total distance if squirrel always starts from tree, goes to nut & comes back to tree
        int totalDist = 0;
        for (int[] nut: nuts)
            totalDist += dist(tree, nut) + dist(nut, tree);

        // Now, we need to remove that 1 nut from totalDist which the squirrel will pick in the first go
        // Earlier we had a nut's distance as 2 * dist(tree, nut)
        // Now, we need to remove dist(tree, nut) from this and add dist(squirrel, nut)
        // minDist = totalDistance - dist(tree, nut) + dist(squirrel, nut)
        // We keep on doing this for every nut till we get a minimum distance
        int minDist = Integer.MAX_VALUE;
        for (int[] nut: nuts)
            minDist = Math.min(minDist, totalDist - dist(tree, nut) + dist(squirrel, nut));

        return minDist;
    }

    public int minDistance2(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDist = 0;
        int maxDist = Integer.MIN_VALUE;
        for (int[] nut: nuts) {
            totalDist += 2 * dist(tree, nut);
            maxDist = Math.max(maxDist, dist(tree, nut) - dist(squirrel, nut));
        }
        return totalDist - maxDist;
    }
}
