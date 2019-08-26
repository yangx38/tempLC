// T = O(n+m)
// S = O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int[] count = new int[26];
        for(int i = 0; i < s.length; i++) {
            count[sc[i]-'a']++;
            count[tc[i]-'a']--;
        }
        
        for(int c : count) {
            if(c != 0) return false;
        }
        return true;
   }
}