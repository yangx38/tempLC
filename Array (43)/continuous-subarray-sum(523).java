// T = O(n)
// S = O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int curMod = 0;
        Map<Integer, Integer> map = new HashMap<>(); map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            curMod += nums[i];
            if(k != 0) curMod = curMod % k;
            if(map.containsKey(curMod)) {
                if(i-map.get(curMod) >= 2) return true;
            } else {
                map.put(curMod, i);
            }
        }
        return false;
    }
}