// T(n) = n+T(n-1) = O(2^n) 每个位置 选或不选 
// S = O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        helper(nums, 0);
        return res;
    }
    
    private void helper(int[] nums, int pos) {
        res.add(new ArrayList<>(subres));
        for(int i = pos; i < nums.length; i++) {
            subres.add(nums[i]);
            helper(nums, i+1);
            subres.remove(subres.size()-1);
        }
    }
}