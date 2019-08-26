// T = O(n)
// S = O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curSum = 0, prefixSum = 0;
        int subSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            subSum = Math.max(curSum-prefixSum, subSum);
            prefixSum = Math.min(curSum, prefixSum);
        }
        return subSum;
    }
}

// T = O(n)
// S = O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; 
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i-1] > 0) dp[i] = dp[i-1]+nums[i];
            else dp[i] = nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// T = O(n)
// S = O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[2]; 
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[(i-1)%2] > 0) dp[i%2] = dp[(i-1)%2]+nums[i];
            else dp[i%2] = nums[i];
            res = Math.max(res, dp[i%2]);
        }
        return res;
    }
}