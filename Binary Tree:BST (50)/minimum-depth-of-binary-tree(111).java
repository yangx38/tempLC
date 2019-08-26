// bottom up:
// T = O(n)
// S = O(h)
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int L = minDepth(root.left);
        int R = minDepth(root.right);
        // leave node
        if(L == 0 && R == 0) return 1;
        // not leave node
        if(L == 0) return R+1;
        if(R == 0) return L+1;
        return Math.min(L, R)+1;
    }
}
// BFS 方法: 
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {  
                TreeNode cur = queue.poll(); 
                if(cur.left == null && cur.right == null) return depth; 
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return depth;
    }
}