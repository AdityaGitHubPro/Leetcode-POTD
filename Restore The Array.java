class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            long num = 0;
            int j = i;
            while (j < n) {
                if (j - i + 1 > String.valueOf(k).length()) {
                    break;
                }
                int x;
                try {
                    x = Integer.parseInt(s.substring(i, j+1));
                } catch (NumberFormatException e) {
                    break;
                }
                if (x > k) {
                    break;
                }
                num += dp[j+1];
                j++;
            }
            dp[i] = (int)(num % 1000000007);
        }
        
        return dp[0];
    }
}
