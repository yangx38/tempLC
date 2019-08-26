class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0; // real pointer
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}