/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] up = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                up[i][j] = left[i][j] = right[i][j] = down[i][j] = 1;
            }
        }

        for (int[] m: mines) {
            up[m[0]][m[1]] = left[m[0]][m[1]] = right[m[0]][m[1]] = down[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (left[i][j] != 0) {
                    left[i][j] = (j-1 >= 0 ? left[i][j-1] + 1 : 1);
                    up[i][j] = (i-1 >= 0 ? up[i-1][j] + 1 : 1);
                }
            }
        }

        for (int i = n-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (right[i][j] != 0) {
                    right[i][j] = (j+1 < n ? right[i][j+1] + 1 : 1);
                    down[i][j] = (i+1 < n ? down[i+1][j] + 1 : 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(
                        ans,
                        Math.min(
                                Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j])
                        )
                );
            }
        }

        return ans;
    }
}
