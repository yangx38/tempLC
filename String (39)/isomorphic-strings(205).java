// T = O(n)
// S = O(1)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] map = new int[256];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            if(map[sc[i]] == 0) map[sc[i]] = tc[i];
            else {
                if(map[sc[i]] != tc[i]) return false;
            }
        }
        
        int[] map2 = new int[256];
        for(int i = 0; i < sc.length; i++) {
            if(map2[tc[i]] == 0) map2[tc[i]] = sc[i];
            else {
                if(map2[tc[i]] != sc[i]) return false;
            }
        }
        return true;
    }
}