// T = O(n)
// S = O(h)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode L = invertTree(root.left);
        TreeNode R = invertTree(root.right);
        root.left = R;
        root.right = L;
        return root;
     }
}

// T = O(n)
// S = O(h)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // swap cur.left & cur.right
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            // offer subtrees back to queue
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
        return root;
    }
}