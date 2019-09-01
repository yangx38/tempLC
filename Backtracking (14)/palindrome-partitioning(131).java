// T = O(2^n*n) 答案总数*构造每个答案需要时间
// S = O(n)
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> subres = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return res;
        helper(s);
        return res;
    }
    
    private void helper(String s) {
        if(s.length() == 0) {
            res.add(new ArrayList<>(subres));
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if(isValid(s.substring(0, i+1))) {
                subres.add(s.substring(0, i+1));
                helper(s.substring(i+1));
                subres.remove(subres.size()-1);
            }
        }
    }
    
    private boolean isValid(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i <= j) {
            if(sc[i++] != sc[j--]) return false;
        }
        return true;
    }
}