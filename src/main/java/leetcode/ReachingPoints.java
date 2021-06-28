/*
 * Author: Kartik Gola
 * Date: 20/01/2021, 11:40
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

public class ReachingPoints {

    // Approach: Every leaf node has only 1 path to root
    // Go from target to source and do (x-y, y) & (x, y-x)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Keep reducing the bigger out of 2 target points
        while (tx > sx && ty > sy) {
            if (ty > tx)
                ty = ty % tx;
            else
                tx = tx % ty;
        }

        if ((tx == sx && ty >= sy && (ty - sy) % sx == 0)
                || (ty == sy && tx >= sx && (tx - sx) % sy == 0))
            return true;

        return false;
    }
}
