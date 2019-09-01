// T = O(n)
// S = O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(map.containsKey(curSum-k)) res += map.get(curSum-k);
            map.put(curSum, map.getOrDefault(curSum, 0)+1);
        }
        return res;
    }
}