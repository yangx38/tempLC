// T = O(n)
// S = O(h)
class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int height = 0;
        for(Node n : root.children) {
            height = Math.max(height, maxDepth(n));
        }
        return 1+height;
    }
}