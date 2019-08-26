// T = O(n*m) - n as strs.length, m as length of shortest word in strs
// S = O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String res = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            while(j < res.length() && j < str.length() && res.charAt(j) == str.charAt(j)) {
                j++; 
            }
            res = res.substring(0, j);
        }
        
        return res;
    }
}