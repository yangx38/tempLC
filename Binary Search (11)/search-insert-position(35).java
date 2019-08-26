// T = O(logn)
// S = O(1)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(target < nums[0]) return 0;
        if(target > nums[n-1]) return n;
        int L = 0, R = n-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(nums[mid] < target) L = mid;
            else R = mid;
        }
        if(nums[L] == target) return L;
        else if(nums[R] == target) return R;
        return L+1;
    }
}