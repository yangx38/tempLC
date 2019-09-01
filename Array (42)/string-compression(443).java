// T = O(n)
// S = O(1)
class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int i = 0, j = 0; 
        while(i < chars.length) {
            char c = chars[i]; int cnt = 0;
            while(i < chars.length && chars[i] == c) {
                i++;
                cnt++;
            }
            chars[j++] = c; 
            if(cnt > 1) {
                for(char cc : String.valueOf(cnt).toCharArray()) {
                    chars[j++] = cc;
                }
            }
        }
        return j;
    }
}