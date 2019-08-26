// T = O(Cn_k) = O(n^min(k, n-k))
// S = O(n)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> subres = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1);
        return res;
    }
    
    private void helper(int n, int k, int pos) {
        if(k == 0) {
            res.add(new ArrayList<>(subres));
            return;
        }
        for(int i = pos; i <= n; i++) {
            subres.add(i);
            helper(n, k-1, i+1);
            subres.remove(subres.size()-1);
        }
    }
}