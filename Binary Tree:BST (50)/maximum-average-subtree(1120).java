// T = O(n)
// S = O(h)
class Solution {
    double res = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return res;
        helper(root);
        return res;
    }
    
    private Node helper(TreeNode root) {
        if(root == null) return new Node(0.0, 0);
        Node L = helper(root.left);
        Node R = helper(root.right);
        
        double sum = root.val+L.sum+R.sum;
        int n = 1+L.childrenNum+R.childrenNum;
        res = Math.max(res, sum/n);
        
        return new Node(sum, n);
    }
    
    class Node {
        double sum = 0.0;
        int childrenNum = 0;
        
        public Node(double sum, int childrenNum) {
            this.sum = sum;
            this.childrenNum = childrenNum;
        }
    }
}