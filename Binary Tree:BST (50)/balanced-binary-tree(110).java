// T = O(n)
// S = O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        int L = height(root.left);
        int R = height(root.right);
        return 1+Math.max(L, R);
    }
}