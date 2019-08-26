// T = O(n)
// S = O(n)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        char[] sc = s.toCharArray();
        for(int i = 1; i < dp.length; i++) {
            if(i-1 >= 0) {
                int num = sc[i-1]-'0';
                if(num >= 1 && num <= 9) dp[i] += dp[i-1];
            }
            if(i-2 >= 0) {
                int num = (sc[i-2]-'0')*10+sc[i-1]-'0';
                if(num >= 10 && num <= 26) dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}

// T = O(n)
// S = O(1)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[3]; 
        dp[0] = 1;
        char[] sc = s.toCharArray();
        for(int i = 1; i <= sc.length; i++) {
            dp[i%3] = 0;
            if(i-1 >= 0) {
                int num = sc[i-1]-'0';
                if(num >= 1 && num <= 9) dp[i%3] += dp[(i-1)%3];
            }
            if(i-2 >= 0) {
                int num = (sc[i-2]-'0')*10+sc[i-1]-'0';
                if(num >= 10 && num <= 26) dp[i%3] += dp[(i-2)%3];
            }
        }
        return dp[s.length()%3];
    }
}