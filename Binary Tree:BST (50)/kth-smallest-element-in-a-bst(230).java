// T = O(n)
// S = O(h)
class Solution {
    Stack<TreeNode> stack = new Stack<>();
    
    public int kthSmallest(TreeNode root, int k) {
        pushLeft(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop(); k--;
            if(k == 0) return cur.val;
            if(cur.right != null) {
                pushLeft(cur.right);
            }
        }
        return -1;
    }
    
    private void pushLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}