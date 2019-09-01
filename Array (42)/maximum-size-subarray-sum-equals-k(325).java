// T = O(n)
// S = O(n)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // prefixSum, index
        map.put(0, -1);
        int curSum = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(map.containsKey(curSum-k)) res = Math.max(res, i-map.get(curSum-k));  // [index+1, i]
            map.putIfAbsent(curSum, i);
        }
        return res;
    }
}