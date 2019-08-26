// T = O(n)
// S = O(1)
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        char[] sc = s.toCharArray();
        for(char c : sc) count[c-'a']++;
        for(int i = 0; i < sc.length; i++) {
            if(count[sc[i]-'a'] == 1) return i;
        } 
        return -1;
    }
}