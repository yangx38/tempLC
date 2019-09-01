// T = O(n)
// S = O(1)
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        
        int L = 0, i = 0, R = nums.length-1;
        while(i <= R) {
            if(nums[i] == 0) {
                // swap nums[i] && nums[L]
                int temp = nums[i];
                nums[i] = nums[L];
                nums[L] = temp;
                i++; L++;
            } 
            else if(nums[i] == 1) {
                i++;
            }
            else {
                // swap nums[i] && nums[R]
                int temp = nums[i];
                nums[i] = nums[R];
                nums[R] = temp;
                R--;
            }
        }
    }
}