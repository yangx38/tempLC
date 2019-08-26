// T = O(n)
// S = O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>(); // curSum, index
        map.put(0, -1);
        int curSum = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(map.containsKey(curSum)) {
                res = Math.max(res, i-map.get(curSum)); // [index+1, i]
            } else {
                map.put(curSum, i);
            }
        }
        return res;
    }
}