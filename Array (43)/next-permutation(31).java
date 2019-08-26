// T = O(n)
// S = O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        // 找第一个
        int firstSmall = -1;
        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                firstSmall = i;
                break;
            }
        }
        // corner case:
        if(firstSmall == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        // 找下一个比 nums[firstsmall] 大的树
        int firstLarge = -1;
        for(int i = nums.length-1; i >= firstSmall; i--) {
            if(nums[i] > nums[firstSmall]) {
                firstLarge = i; 
                break;
            }
        }
        // swap
        swap(nums, firstSmall, firstLarge);
        // reverse
        reverse(nums, firstSmall+1, nums.length-1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
}