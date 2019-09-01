// T = O(n)
// S = O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 1) return new int[]{0, 0};
        Map<Integer, Integer> map = new HashMap<>(); // num, index
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}