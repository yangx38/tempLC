// T = O(n)
// S = O(h)
class Solution {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        pushLeft(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) pushLeft(cur.right);
        }
        return res;
    }
    
    private void pushLeft(TreeNode cur) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}