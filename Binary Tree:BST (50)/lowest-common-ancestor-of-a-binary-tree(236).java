// T = O(n)
// S = O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if(L != null && R != null) return root;
        // if(L == null && R == null) return null;
        if(L == null) return R;
        return L;
    }
}

// T = O(n)
// S = O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        Map<TreeNode, TreeNode> map = new HashMap<>(); map.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // map contains both p and q
        while(!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                map.put(cur.left, cur);
                queue.offer(cur.left);
            } 
            if(cur.right != null) {
                map.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
        Set<TreeNode> set = new HashSet<>(); // ancestor
        while(p != null) {
            set.add(p);
            p = map.get(p); // 往上爬
        }
        while(!set.contains(q)) q = map.get(q);
        return q;
    }
}