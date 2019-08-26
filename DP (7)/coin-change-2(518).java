// T = O(n*amount)
// S = O(n*amount)
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1]; // 
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 0; j <= amount; j++) {
                if(j-coins[i-1] >= 0) dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}

// T = O(n*amount)
// S = O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int[] dp = new int[amount+1]; // 
        dp[0] = 1;
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if(j-coins[i-1] >= 0) dp[j] = dp[j] + dp[j-coins[i-1]];
            }
        }
        return dp[amount];
    }
}