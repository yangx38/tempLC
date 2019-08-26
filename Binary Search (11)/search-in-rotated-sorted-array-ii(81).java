// T = O(logn) wst: O(n)
// S = O(1)
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int L = 0, R = nums.length-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(nums[mid] == nums[R]) R--;
            else if(nums[mid] < nums[R]) {
                if(target >= nums[mid] && target <= nums[R]) L = mid;
                else R = mid;
            }
            else {
                if(target >= nums[L] && target <= nums[mid]) R = mid;
                else L = mid;
            }
        }
        if(nums[L] == target || nums[R] == target) return true;
        return false;
    }
}