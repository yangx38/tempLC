// 题意: 
    // given s and t, return boolean whether 增删换 一步能从s变到t
// 思路: 
    // corner cases
    // 遍历
// T = O(n)
// S = O(1)

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || s.equals(t)) return false;
        if(Math.abs(s.length() - t.length()) > 1) return false;
        
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) == t.charAt(i)) continue;
            // insert s = "ab", t = "acb"
            if(s.length() < t.length()) return t.substring(i+1).equals(s.substring(i));
            // delete
            else if(t.length() < s.length()) return s.substring(i+1).equals(t.substring(i));
            // replace
            else return s.substring(i+1).equals(t.substring(i+1));
        }
        return true;
    }
}