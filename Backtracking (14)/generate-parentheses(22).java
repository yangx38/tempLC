// T = 上限: O(2^n) => O(n!) Catalan number
// S = O(n)
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n == 0) return res;
        helper(n, n, ""); 
        return res;
    }

    private void helper(int L, int R, String subres) {
        if(L > R || L < 0 || R < 0) return;
        if(L == 0 && R == 0) {
            res.add(subres);
            return;
        }
        helper(L-1, R, subres+"(");
        helper(L, R-1, subres+")");
    }
}