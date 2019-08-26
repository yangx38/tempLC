// T = O(n)
// S = O(h)
class Solution {
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int L = Math.max(0, helper(root.left));
        int R = Math.max(0, helper(root.right));
        res = Math.max(L+R+root.val, res);
        return Math.max(L, R)+root.val;
    }
}