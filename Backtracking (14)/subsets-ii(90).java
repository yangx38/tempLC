// T(n) = n+T(n-1) = O(2^n) 每个位置 选或不选 
// S = O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }
    
    private void helper(int[] nums, int pos) {
        res.add(new ArrayList<>(subres));
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;
            subres.add(nums[i]);
            helper(nums, i+1);
            subres.remove(subres.size()-1);
            
        }
    }
}