package leetcode;

public class CoinChange2 {

    // TODO
    public int coinChange2TopDown(int[] coins, int amount, int j) {
        return -1;
    }

    public int coinChange2BottomUp(int[] coins, int amount) {
        // ways[i][j] = no. of ways to get amount `j` by using first `i` coins ( or coins[0...i) )
        // ways[i][j] = sum{ ways that make amount `j`, without `i-1`th coin, ways that make amount `j - coins[i - 1]` }
        // ways[i][j] = sum{ ways[i - 1][j], ways[i][j - coins[i - 1]] }
        int[][] ways = new int[coins.length+1][amount+1];
        ways[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            ways[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                ways[i][j] = ways[i-1][j] + (j >= coins[i-1] ? ways[i][j-coins[i-1]] : 0);
            }
        }
        return ways[coins.length][amount];
    }

}
