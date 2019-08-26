// T(n) = n*T(n-1) = O(n!) 
// S = O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    int[] visited;
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        visited = new int[nums.length];
        helper(nums, 0);
        return res;
    }
    
    private void helper(int[] nums, int pos) {
        if(subres.size() == nums.length) {
            res.add(new ArrayList<>(subres));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            // 剪枝
            if(visited[i] == 1) continue;
            subres.add(nums[i]);
            visited[i] = 1;
            helper(nums, i+1);
            visited[i] = 0;
            subres.remove(subres.size()-1);
        }
    }
}