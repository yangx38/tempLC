// T(n) = T(n-1)+O(n) = O(2^n) 每个位置选/不选
// S = O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return res;
        helper(candidates, target, 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, int pos) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(subres));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            subres.add(candidates[i]);
            helper(candidates, target-candidates[i], i);
            subres.remove(subres.size()-1);
        }
    }
}