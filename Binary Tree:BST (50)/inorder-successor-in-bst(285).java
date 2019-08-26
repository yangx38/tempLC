// T = O(logN) worst case O(n)
// S = O(h)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val >= root.val) return inorderSuccessor(root.right, p);
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            if(left == null) return root;
            else return left;
        }
    }
}

// T = O(logN) worst case O(n)
// S = O(h)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while(root != null) {
            if(root.val <= p.val) {
                root = root.right;
            } else {
                pre = root;
                root = root.left;
            }
        }
        return pre;
    }
}