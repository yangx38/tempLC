// T = O(n)
// S = O(n)
class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)) map.put(num, new int[]{1, i, i});
            else {
                int[] temp = map.get(num);
                temp[0]++; temp[2] = i;
            }
        }
        int res = Integer.MAX_VALUE, maxFreq = Integer.MIN_VALUE;
        for(int[] value : map.values()) {
            maxFreq = Math.max(maxFreq, value[0]);
        }
        
        for(int[] value : map.values()) {
            if(value[0] == maxFreq) {
                res = Math.min(res, value[2]-value[1]+1);
            }
        }
        return res;
    }
}