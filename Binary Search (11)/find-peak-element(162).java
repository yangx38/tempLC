// T = O(logn)
// S = O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int L = 0, R = nums.length-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(nums[mid] < nums[mid+1]) L = mid;
            else R = mid;
        }
        if(nums[R] > nums[L]) return R;
        return L;
    }
}