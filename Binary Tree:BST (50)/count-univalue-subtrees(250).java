// T = O(n)
// S = O(h)
class Solution {
    int res = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        isUnivalue(root);
        return res;
    }
    
    private boolean isUnivalue(TreeNode root) {
        if(root == null) return true;
        boolean L = isUnivalue(root.left);
        boolean R = isUnivalue(root.right);
        if(L && R && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
            res++;
            return true;
        }
        return false;
    }
}