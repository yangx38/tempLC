// T = O(n)
// S = O(n)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i < nums.length) {
            int L = i;
            while(i+1 < nums.length && nums[i]+1 == nums[i+1]) i++;
            if(i != L) res.add(nums[L]+"->"+nums[i]);
            else res.add(String.valueOf(nums[i]));
            i++;
        }
        return res;
    }
}