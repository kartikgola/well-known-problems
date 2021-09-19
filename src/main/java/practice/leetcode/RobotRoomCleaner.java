/*
 * Author: Kartik Gola
 * Date: 9/20/21, 12:01 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    private interface Robot {
        public boolean move();
        public void turnRight();
        public void clean();
    }

    int[][] po = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private String key(int i, int j) {
        return i+":"+j;
    }

    private void clean(Robot r, int i, int j, int dir, Set<String> vis) {
        vis.add(key(i, j));
        r.clean();

        for (int k = dir; k < dir+4; ++k) {
            int x = po[k%4][0] + i;
            int y = po[k%4][1] + j;
            if (!vis.contains(key(x, y))) {
                if (r.move()) {
                    clean(r, x, y, k%4, vis);
                }
            }
            r.turnRight();
        }
        r.turnRight();
        r.turnRight();
        r.move();
        r.turnRight();
        r.turnRight();
    }

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }
}
