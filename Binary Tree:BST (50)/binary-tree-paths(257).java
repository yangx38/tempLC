// T = O(n)
// S = O(n)
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        helper(root, "");
        return res;
    }
    
    private void helper(TreeNode root, String subres) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            subres += root.val;
            res.add(subres);
            return;
        }
        subres += root.val;
        helper(root.left, subres+"->");
        helper(root.right, subres+"->");
    }
}