class Solution {
    public String stoneGameIII(int[] stoneValue) {
        if(stoneValue.length == 1){
            if(stoneValue[0] < 0){
                return "Bob";
            }
            else if(stoneValue[0] == 0){
                return "Tie";
            }
            else{
                return "Alice";
            }
        }
        if(stoneValue.length < 3){
            return "Alice";
        }
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            int temp = 0;
            for(int k = 1; k <= 3; k++){
                if(i + k > n){
                    break;
                }
                temp = temp + stoneValue[i + k - 1];
                dp[i] = Math.max(dp[i], temp + prefixSum[n] - prefixSum[i + k] - dp[i + k]);
            }
        }
        if(dp[0] > prefixSum[n] - dp[0]){
            return "Alice";
        }
        else if(dp[0] < prefixSum[n] - dp[0]){
            return "Bob";
        }
        return "Tie";
    }
}
