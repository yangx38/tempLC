// T = O(n)
// S = O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int temp = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            temp = temp*nums[i+1];
            res[i] = res[i] * temp;
        }
        return res;
    }
}