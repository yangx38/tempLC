// T = O(n)
// S = O(n)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(i <= nums.length-2 && nums[i]+1 == nums[i+1]) i++;
            if(num == nums[i]) res.add(num+"");
            else res.add(num+"->"+nums[i]);
        }
        return res;
    }
}