// T = O(n)
// S = O(h)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) 
            return true;
        boolean L = hasPathSum(root.left, sum-root.val);
        boolean R = hasPathSum(root.right, sum-root.val);
        return L || R;
    }
}