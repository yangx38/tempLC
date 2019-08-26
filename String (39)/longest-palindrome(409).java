// T = O(n)
// S = O(1)
class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() < 1) return 0;
        
        char[] sc = s.toCharArray();
        int[] freq = new int[256];
        for(int i = 0; i < sc.length; i++) freq[sc[i]]++;
        
        int res = 0; boolean oddNum = false;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                if(freq[i] % 2 == 0) res += freq[i];
                else {
                    res += freq[i]-1;
                    if(freq[i] > 0) oddNum = true;
                }
            }
        }
        if(oddNum) res++;
        return res;
    }
}