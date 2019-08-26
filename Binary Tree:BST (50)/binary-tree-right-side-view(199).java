class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(i == size-1) res.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }
}

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(res.size() == level) res.add(root.val);
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
    
}