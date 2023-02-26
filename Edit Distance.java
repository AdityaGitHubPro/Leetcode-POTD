Question Link: https://leetcode.com/problems/edit-distance/



class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D array to store the minimum edit distance
        int[][] dp = new int[m+1][n+1];
        
        // Initialize the first row and column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the rest of the array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int replace = dp[i-1][j-1] + 1;
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        
        // Return the minimum edit distance
        return dp[m][n];
    }
}
