// T = O(n)
// S = O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean L2R = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subres = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(L2R) subres.add(cur.val);
                else subres.add(0, cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(subres);
            L2R = !L2R;
        }
        return res;
    }
}