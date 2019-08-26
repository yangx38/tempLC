// T = O(n^3)
// S = O(n)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-4; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j <= nums.length-3; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int L = j+1, R = nums.length-1;
                while(L < R) {
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while(L < R && nums[L] == nums[L+1]) L++;
                        while(L < R && nums[R] == nums[R-1]) R--;
                        L++; R--;
                    }
                    else if(sum < target) L++;
                    else R--;
                }
            }
        }
        return res;
    }
}