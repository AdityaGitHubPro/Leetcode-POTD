Question Link: https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/



class Solution {
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        long dp[][][] = new long[k + 1][n + 1][m + 1];
        for(int i = 0; i <= k; ++ i){
            for(int j = 0; j <= n; ++ j){
                for(int l = 0; l <= m; ++ l){
                    dp[i][j][l] = waysHelperTabular(pizza, i, j, l, dp);
                }
            }
        }

        return (int)(dp[k][0][0] % (((int)(Math.pow(10, 9)) + 7)));
    }

    private long waysHelperTabular(String [] pizza, int k, int i, int j, long dp[][][]){
        int n = pizza.length;
        int m = pizza[0].length();

        if(k == 0){
            return 0;
        }
        
        if(k == 1){
            for(int l = i; l < n; ++ l){
               for(int h = j; h < m; ++ h){
                     if(pizza[l].charAt(h) == 'A'){
                         return 1;
                     }
                 }
            }
            return 0;
        }

        long opt1 = 0;
        boolean flag = false;
        for(int x = j; x < m; ++ x){
            for(int l = i; l < n; ++ l){
                if(flag || pizza[l].charAt(x) == 'A'){
                    flag = true;
                    int newK = k - 1;
                    int newI = i;
                    int newJ = x + 1;
                    if(newI < n && newJ < m){
                        opt1 += dp[newK][newI][newJ];
                    }
                    break;
                }
            }
        }

        long opt2 = 0;
        flag = false;
        for(int x = i; x < n; ++ x){
            for(int l = j; l < m; ++ l){
                if(flag || pizza[x].charAt(l) == 'A'){
                    flag = true;
                    int newK = k - 1;
                    int newI = x + 1;
                    int newJ = j;
                    if(newI < n && newJ < m){
                        opt2 += dp[newK][newI][newJ];
                    }
                    break;
                }
            }
        }

        return opt1 + opt2;
    }
}
