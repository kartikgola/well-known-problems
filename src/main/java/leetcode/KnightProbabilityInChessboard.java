/*
 * Author: Kartik Gola
 * Date: 1/16/21, 2:06 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/knight-probability-in-chessboard/
 */

package leetcode;

public class KnightProbabilityInChessboard {

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K+1];
        dp[r][c][0] = 1;

        final int[][] pos = new int[][]{{-2,1}, {-1,2}, {1,2}, {2,1},
                {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};

        for (int step = 0; step < K; ++step) {
            // Check all points that have positive probability in this step
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (dp[i][j][step] > 0) {
                        // Calculate probabilities of all possible points
                        for (int[] p: pos) {
                            final int x = i + p[0], y = j + p[1];
                            if (x >= 0 && x < N && y >= 0 && y < N) {
                                dp[x][y][step+1] += dp[i][j][step] / 8d;
                            }
                        }
                    }
                }
            }
        }

        // Sum up the probabilities of all points with step = K
        double ans = 0.0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                ans += dp[i][j][K];
            }
        }

        return ans;
    }
}
