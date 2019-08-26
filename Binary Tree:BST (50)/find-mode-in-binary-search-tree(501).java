// T = O(n)
// S = O(n)
class Solution {
    int maxFreq = 0;
    int curFreq = 0;
    Integer pre = null;
    List<Integer> res = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        helper(root);
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) resArr[i] = res.get(i);
        return resArr;
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(pre == null) {
            maxFreq = 1; curFreq = 1; res.add(root.val);
        } else {            
            if(root.val == pre) curFreq++;
            else curFreq = 1;
            
            if(curFreq > maxFreq) {
                maxFreq = curFreq;
                res.clear();
                res.add(root.val);
            } else if(curFreq == maxFreq) {
                res.add(root.val);
            }
            
        }
        pre = root.val;
        helper(root.right);
    }
}