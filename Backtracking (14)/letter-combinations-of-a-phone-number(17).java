// T = O(3^n)  即答案总数 * 构造每个答案需要的时间
// S = O(n) 
class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        helper(digits, "", 0);
        return res;
    }

    private void helper(String digits, String subres, int pos) {
        if(subres.length() == digits.length()) {
            res.add(subres);
            return;
        }
        String letters = map[digits.charAt(pos)-'0'];
        for(int i = 0; i < letters.length(); i++) {
            helper(digits, subres+letters.charAt(i), pos+1);
        }
    }
}