// T = O(n)
// S = O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int curMod = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            curMod += nums[i];
            if(k != 0) curMod %= k;
            if(curMod < 0) curMod += k; // b/c all numbers in array are non-negative, we can skip this step; OW if there exists neg, we need this step
            if(map.containsKey(curMod)) {
                if(i-map.get(curMod) >= 2)
                return true;
            }
            map.putIfAbsent(curMod, i);
        }
        return false;
    }
}