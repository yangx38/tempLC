// T = O(n)
// S = O(h)
class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val, 0);
        return res;
    }
    
    private void helper(TreeNode root, int target, int subres) {
        if(root == null) return;   
        if(root.val == target) subres++;
        else subres = 1;
        res = Math.max(res, subres);
        
        helper(root.left, root.val+1, subres);
        helper(root.right, root.val+1, subres);
    }
}