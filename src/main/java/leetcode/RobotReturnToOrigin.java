/*
 * Author: Kartik Gola
 * Date: 21/01/2021, 21:55
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/robot-return-to-origin/
 */

package leetcode;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch: moves.toCharArray()) {
            switch(ch) {
                case 'U':
                    y++; break;
                case 'L':
                    --x; break;
                case 'R':
                    ++x; break;
                case 'D':
                    --y; break;
            }
        }
        return x == 0 && y == 0;
    }
}
