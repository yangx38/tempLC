// T = O(2^n) 每个位置可以是number/character
// S = O(n)
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
        helper(word, "", 0, 0);
        return res;
    }

    public void helper(String word, String subres, int count, int pos) {
        if(pos == word.length()) {
            if(count > 0) subres += count;
            res.add(subres);
            return;
        } 
        // place number
        helper(word, subres, count+1, pos+1);
        // place character
        String newSub = subres+(count > 0 ? count : "")+word.charAt(pos);
        helper(word, newSub, 0, pos+1);
    }
}
