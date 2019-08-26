// T = O(n)
// S = O(h)
class Solution {
    TreeNode pre = null;
    
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        TreeNode dummy = new TreeNode(0); dummy.right = root;
        pre = dummy;
        helper(root);
        return dummy.right;
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        
        root.left = null;
        pre.right = root;
        pre = pre.right;
        
        helper(root.right);
    }
}