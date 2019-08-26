// T = O(n)
// S = O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for(int num : nums) sum += num;
        
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0) leftSum += nums[i-1];
            if(leftSum*2 == sum-nums[i]) return i;
        }
        return -1;
    }
}