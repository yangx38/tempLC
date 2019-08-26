// T = O(n^2)
// S = O(n^2)
class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int[][] palin = constructPanlin(s);
        int[] dp = new int[s.length()+1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for(int j = 0; j <= i-1; j++) {
                if(palin[j][i-1] == 1) dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[s.length()]-1;
    }
    
    private int[][] constructPanlin(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int[][] palin = new int[n][n]; 
        // panlin[i][j] - s[i..j] middle out
        for(int c = 0; c < n; c++) {
            int i = c, j = c;
            while(i >= 0 && j < n && sc[i] == sc[j]) palin[i--][j++] = 1;
        }
        for(int c = 0; c < n; c++) {
            int i = c, j = c+1;
            while(i >= 0 && j < n && sc[i] == sc[j]) palin[i--][j++] = 1;
        }
        return palin;
    }
}