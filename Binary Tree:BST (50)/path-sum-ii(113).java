// T = O(n)
// S = O(h)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        helper(root, sum, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int target, List<Integer> subres) {
        if(root == null) return;
        subres.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                res.add(new ArrayList<>(subres));
                // subres.remove(subres.size()-1);
                // return;
            }
        }
        helper(root.left, target-root.val, subres);
        helper(root.right, target-root.val, subres);
        subres.remove(subres.size()-1);
    }
}