// T = O(n)
// S = O(h)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return res;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return -1;
        int L = helper(root.left), R = helper(root.right);
        int height = Math.max(L, R)+1;
        if(res.size() == height) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        root.left = null;
        root.right = null;
        return height;
    }
}