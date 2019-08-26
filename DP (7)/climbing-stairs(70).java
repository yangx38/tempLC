// T = O(n)
// S = O(n)
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            if(i-1 >= 0) dp[i] += dp[i-1];
            if(i-2 >= 0) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}

// T = O(n)
// S = O(1)
class Solution {    
    public int climbStairs(int n) {
        if(n == 0) return 1;
        int[] dp = new int[3];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i%3] = 0;
            if(i-1 >= 0) dp[i%3] += dp[(i-1)%3];
            if(i-2 >= 0) dp[i%3] += dp[(i-2)%3];
        }
        return dp[n%3];
    }
}