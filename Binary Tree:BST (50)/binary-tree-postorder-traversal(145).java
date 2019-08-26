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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                res.add(0, cur.val);
                if(cur.left != null) stack.push(cur.left);
                if(cur.right != null) stack.push(cur.right);
            }
        }
        return res;
    }
}