// T = O(n)
// S = O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curSum = 0, res = Integer.MAX_VALUE; 
        for(int L = 0, R = 0; R < nums.length; R++) {
            curSum += nums[R];
            while(L <= R && curSum >= s) {
                res = Math.min(res, R-L+1);
                curSum -= nums[L++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}