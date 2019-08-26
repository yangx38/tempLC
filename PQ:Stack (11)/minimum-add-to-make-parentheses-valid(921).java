// T = O(n)
// S = O(1)
class Solution {
    public int minAddToMakeValid(String S) {
        if(S == null || S.length() == 0) return 0;
        char[] sc = S.toCharArray();
        int L = 0, R = 0;
        for(char c : sc) {
            if(c != '(' && c != ')') continue;
            if(c == ')') {
                if(L == 0) R++;
                else L--;
            } else {
                L++;
            }
        }
        return L+R;
    }
}