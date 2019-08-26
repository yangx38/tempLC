// T = O(n)
// S = O(logn) - balanced BST 高度 = logn
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int L = 0, R = nums.length-1;
        return helper(nums, L, R);
    }
    
    private TreeNode helper(int[] nums, int L, int R) {
        if(R < L) return null;
        int mid = (R-L)/2+L;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, L, mid-1);
        root.right = helper(nums, mid+1, R);
        return root;
    }
}