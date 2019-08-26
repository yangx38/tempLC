// T = O(logn) worst case: O(n) 
// S = O(1)
class Solution {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(nums[mid] == nums[R]) R--;
            else if(nums[mid] > nums[R]) L = mid;
            else R = mid;
        }
        if(nums[L] < nums[R]) return nums[L];
        return nums[R];
    }
}