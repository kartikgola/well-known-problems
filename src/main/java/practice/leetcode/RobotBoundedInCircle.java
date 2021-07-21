/*
 * Author: Kartik Gola
 * Date: 20/01/2021, 11:40
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package practice.leetcode;

public class RobotBoundedInCircle {

    class Robot {
        int x = 0,
            y = 0,
            pos = 0;

        void left() { pos = pos - 1 == -1 ? 3 : pos - 1; }

        void right() { pos = pos + 1 == 4 ? 0 : pos + 1; }

        void move() {
            switch (pos) {
                case 0: ++y; break;
                case 1: ++x; break;
                case 2: --y; break;
                case 3: --x; break;
            }
        }
    }

    public boolean isRobotBounded(String instructions) {
        Robot r = new Robot();
        for (char ch: instructions.toCharArray()) {
            if (ch == 'L') r.left();
            else if (ch == 'R') r.right();
            else r.move();
        }
        int dist = r.x * r.x + r.y * r.y;
        return r.pos != 0 || dist == 0;
    }
}
