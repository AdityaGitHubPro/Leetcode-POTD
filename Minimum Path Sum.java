Question Link: https://leetcode.com/problems/minimum-path-sum/



public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 > m - 1 && j + 1 > n - 1)
                    dp[i][j] = grid[i][j];

                else if (i + 1 > m - 1)
                    dp[i][j] = dp[i][j + 1] + grid[i][j];

                else if (j + 1 > n - 1)
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                else {
                    dp[i][j] = Math.min(dp[i][j + 1] + grid[i][j], dp[i + 1][j] + grid[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
