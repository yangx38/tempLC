// T = O(logn) wst case: O(n)
// S = O(h)
class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null) {
            if(Math.abs(target-root.val) < Math.abs(target-res)) res = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}

