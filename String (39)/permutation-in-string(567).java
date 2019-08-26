// whether s1' permutation is the substring of s2
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < s1.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
        char[] sc = s2.toCharArray();
        int L = 0, R = 0, unmatchedCnt = s1.length();
        while(R < sc.length) {
            char rc = sc[R++];
            if(!map.containsKey(rc)) continue;
            if(map.get(rc) > 0) unmatchedCnt--;
            map.put(rc, map.get(rc)-1);
            if(unmatchedCnt != 0) continue;
            
            while(unmatchedCnt == 0) {
                char lc = sc[L++];
                if(!map.containsKey(lc)) continue;                
                if(map.get(lc) == 0) unmatchedCnt++; // **HIGHLIGHT if(map.get(lc) == 0) **
                map.put(lc, map.get(lc)+1);
            }
            if(R-L+1 == s1.length() && L-1 >= 0) return true;
        }
        return false;
    }
}


// whether s1' permutation is the substring of s2
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < s1.length()) return false;
        
        int[] map = new int[256];
        for(char c : s1.toCharArray()) map[c]++;
        
        char[] sc = s2.toCharArray();
        int L = 0, R = 0, unmatchedCnt = s1.length();
        while(R < sc.length) {
            char rc = sc[R++];
            if(map[rc]-- > 0) unmatchedCnt--;
            if(unmatchedCnt != 0) continue;
            
            while(unmatchedCnt == 0) {
                char lc = sc[L++];
                if(map[lc]++ == 0) unmatchedCnt++; // **HIGHLIGHT if(map.get(lc) == 0) **
            }
            if(R-L+1 == s1.length() && L-1 >= 0) return true;
        }
        return false;
    }
}