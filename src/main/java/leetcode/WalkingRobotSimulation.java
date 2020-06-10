/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class WalkingRobotSimulation {

    enum Dir {
        N, S, E, W
    }

    private Dir turnLeft(Dir dir) {
        switch ( dir ) {
            case N: return Dir.W;
            case S: return Dir.E;
            case E: return Dir.N;
            case W: return Dir.S;
            default: return Dir.N;
        }
    }

    private Dir turnRight(Dir dir) {
        switch ( dir ) {
            case N: return Dir.E;
            case S: return Dir.W;
            case E: return Dir.S;
            case W: return Dir.N;
            default: return Dir.N;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        Dir d = Dir.N;
        // Min needed space is 30k + 30k + 1
        boolean[][] grid = new boolean[60_001][60_001];
        final int min = -30_000;
        final int max = 30_000;

        // Mark obstacles as true
        for ( int[] obs : obstacles ) {
            grid[obs[0] + max][obs[1] + max] = true;
        }

        for ( int cmd : commands ) {
            if ( cmd == -1 ) {
                d = turnRight(d);
            } else if ( cmd == -2 ) {
                d = turnLeft(d);
            } else {
                switch ( d ) {
                    case N:
                        // Increase y
                        while ( !grid[x + max][y + max + 1] && cmd-- > 0 ) y += 1;
                        System.out.println("Here");
                        break;
                    case S:
                        // Decrease y
                        while ( !grid[x + max][y + max - 1] && cmd-- > 0 ) y -= 1;
                        break;
                    case E:
                        // Increase x
                        while ( !grid[x + max + 1][y + max] && cmd-- > 0 ) x += 1;
                        break;
                    case W:
                        // Decrease x
                        while ( !grid[x + max - 1][y + max] && cmd-- > 0 ) x -= 1;
                        break;
                }
            }
        }

        return (x * x) + (y * y);
    }

}
