// T = O(n^2)
// S = O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[nums.length-1];
        for(int i = 0; i <= nums.length-3; i++) {
            int L = i+1, R = nums.length-1;
            while(L < R) {
                int cur = nums[L] + nums[R] + nums[i];
                if(cur == target) {
                    return target;
                } else if(cur < target) {
                    if(Math.abs(cur-target) < Math.abs(res-target)) res = cur;
                    L++;
                } else {
                    if(Math.abs(cur-target) < Math.abs(res-target)) res = cur;
                    R--;
                }
            }
        }
        return res;
    }
}