/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
