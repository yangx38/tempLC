/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // iterative:
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if(cur.right != null) stack.push(cur.right);
                if(cur.left != null) stack.push(cur.left);
            }
        }
        return res;
    }
}

// recursive
class Solution {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return res;
        helper(root);
        return res;
    }
    
    private void helper(TreeNode cur) {
        if(cur == null) return;
        res.add(cur.val);
        helper(cur.left);
        helper(cur.right);
    }
}