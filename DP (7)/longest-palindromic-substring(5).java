// T = O(n^2)
// S = O(1)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String res = "";
        char[] sc = s.toCharArray();
        int n = sc.length;
        for(int c = 0; c < n; c++) {
            int i = c, j = c;
            while(i >= 0 && j < n && sc[i] == sc[j]) {i--; j++;}
            String subres = s.substring(i+1, j);
            if(subres.length() > res.length()) res = subres;
        }
        for(int c = 0; c < n; c++) {
            int i = c, j = c+1;
            while(i >= 0 && j < n && sc[i] == sc[j]) {i--; j++;}
            String subres = s.substring(i+1, j);
            if(subres.length() > res.length()) res = subres;
        }
        return res;
    }
    
}