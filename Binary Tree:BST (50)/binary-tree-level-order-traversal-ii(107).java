class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subres = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                subres.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(0, subres);
        }
        return res;
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()) res.add(0, new ArrayList<>()); 
        res.get(res.size()-1-level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}