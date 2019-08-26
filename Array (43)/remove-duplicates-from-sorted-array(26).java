// T = O(n)
// S = O(1)	
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] != nums[i-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}