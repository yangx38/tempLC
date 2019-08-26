// T = O(n)
// S = O(n)
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int L = rob(root.left);
        int R = rob(root.right);
        int LL = 0, RR = 0; // max left without root.left node / root.right node
        if(root.left != null) LL = rob(root.left.left)+rob(root.left.right); 
        if(root.right != null) RR = rob(root.right.left)+rob(root.right.right); 
        int res = Math.max(LL+RR+root.val, L+R);
        map.put(root, res);
        return res;
    }
}