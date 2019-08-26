// T = O(n)
// S = O(h)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                if(cur.right != null) stack.push(cur.right);
                if(cur.left != null) stack.push(cur.left);
                if(!stack.isEmpty()) {
                    cur.right = stack.peek();
                }
                cur.left = null;
            }
        }
    }
}

// T = O(n)
// S = O(h)
class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

// T = O(n)
// S = O(h)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null) {
            flatten(root.right);
            return;
        }
        
        TreeNode hl = root.left;
        TreeNode hr = root.right;
        flatten(root.left);
        flatten(root.right);
        
        root.right = hl; 
        root.left = null; 
        
        while(hl.right != null) hl = hl.right;
        hl.right = hr;
    }
}

