// T = O(n)
// S = O(1)
class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min*nums[i], nums[i]);
            max = Math.max(max*nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}