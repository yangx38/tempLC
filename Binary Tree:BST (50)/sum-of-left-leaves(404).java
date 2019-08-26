// T = O(n)
// S = O(h)
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) res += root.left.val;
            else res += sumOfLeftLeaves(root.left);
        } 
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}

// T = O(n)
// S = O(h)
class Solution {
    Stack<TreeNode> stack = new Stack<>();
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        stack.push(root);
        int res = 0;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null) {
                if(cur.left.left == null && cur.left.right == null) res += cur.left.val;
                else stack.push(cur.left);
            }
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}

// T = O(n)
// S = O(h)
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        DFS(root);
        return sum;
    }
    
    private void DFS(TreeNode root) {
        if(root == null) return;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        DFS(root.left);
        DFS(root.right);
    }
}