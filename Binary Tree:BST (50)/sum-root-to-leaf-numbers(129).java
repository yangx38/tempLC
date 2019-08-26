// T = O(n)
// S = O(h)
class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int subres) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            subres = subres*10+root.val;
            res += subres;
            return;
        }
        helper(root.left, subres*10+root.val);
        helper(root.right, subres*10+root.val);
    }
}