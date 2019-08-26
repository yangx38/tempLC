// T = O(n)
// S = O(h)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return 1+Math.max(L, R);
    }
}