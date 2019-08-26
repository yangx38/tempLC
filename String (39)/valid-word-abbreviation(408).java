// T = O(n)
// S = O(1)
class Solution {
    public boolean validWordAbbreviation(String s, String p) {
        if(s == null && p == null) return true; if(s == null || p == null) return false;
        if(s.length() == 0 && p.length() == 0) return true; if(s.length() == 0 || p.length() == 0) return false;

        int i = 0, j = 0, m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        while(i < m && j < n) {
            if(Character.isDigit(pc[j])) {
                if(pc[j] == '0') return false;
                int num = 0;
                while(j < n && pc[j] >= '0' && pc[j] <= '9') {
                    num = num*10 + (pc[j]-'0');
                    j++;
                }
                i += num;
            } else {
                if(sc[i++] != pc[j++]) return false;
            }
        }
        return i == m && j == n;
    }
}