// T = O(n)
// S = O(h)
class BSTIterator {
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    private void pushLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right != null) {
            pushLeft(cur.right);
        }
        return cur.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */