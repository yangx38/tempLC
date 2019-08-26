// T = O(n)
// S = O(h)
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        Node res = helper(root);
        return res.root;
    }
    
    private Node helper(TreeNode root) {
        if(root == null) return new Node(-1, null);
        Node L = helper(root.left);
        Node R = helper(root.right);
        if(L.height == R.height) return new Node(L.height+1, root);
        else if(L.height > R.height) return new Node(L.height+1, L.root);
        else return new Node(R.height+1, R.root);
    }
    
    class Node {
        int height;
        TreeNode root;
        public Node(int height, TreeNode root) {
            this.height = height;
            this.root = root;
        } 
    }
}