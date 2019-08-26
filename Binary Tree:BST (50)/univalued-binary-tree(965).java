// T = O(n)
// S = O(h)
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        boolean L = isUnivalTree(root.left);
        boolean R = isUnivalTree(root.right);
        if(L && R && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) return true;
        return false;
    }
}