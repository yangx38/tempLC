// T = O(n^2)
// S = O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        for(int i = 0; i <= nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i+1, R = nums.length-1;
            while(L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[L], nums[R], nums[i]));
                    while(L < R && nums[L+1] == nums[L]) L++;
                    while(L < R && nums[R-1] == nums[R]) R--;
                    L++; R--;
                } 
                else if(sum < 0) L++;
                else R--;
            }
        }
        return res;
    }
}