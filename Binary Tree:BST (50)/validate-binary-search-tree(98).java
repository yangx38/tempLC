// T = O(n)
// S = O(h)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min) return false;
        if(root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}