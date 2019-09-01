// T(n) = n*T(n-1) = O(n!) 
// S = O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, new int[nums.length]);
        return res;
    }
    
    private void helper(int[] nums, int[] visited) {
        if(subres.size() == nums.length) {
            res.add(new ArrayList<>(subres));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1 || i > 0 && nums[i] == nums[i-1] && visited[i-1] == 0) continue;
            subres.add(nums[i]);
            visited[i] = 1;
            helper(nums, visited);
            visited[i] = 0;
            subres.remove(subres.size()-1);
        }
    }
}