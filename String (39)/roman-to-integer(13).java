// T = O(n)
// S = O(1)
class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] sc = s.toCharArray();
        int res = 0;
        for(int i = 0; i < sc.length; i++) {
            if(i > 0 && toNum(sc[i]) > toNum(sc[i-1])) {
                res -= toNum(sc[i-1]);
                res += toNum(sc[i])-toNum(sc[i-1]);
            } else res += toNum(sc[i]);
        }
        return res;
    }

    private int toNum(char c) {
        if(c == 'I') return 1;
        else if(c == 'V') return 5;
        else if(c == 'X') return 10;
        else if(c == 'L') return 50;
        else if(c == 'C') return 100;
        else if(c == 'D') return 500;
        else return 1000;
    }
}