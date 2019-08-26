// T = O(n) - n as s.length
// S = O(1) - only 26 letters
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
        char[] sc = s.toCharArray();
        int L = 0, R = 0, unmatchedCnt = p.length();
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
            if(R-L+1 == p.length() && L-1 >= 0) res.add(L-1); 
        }
        return res;
    }
}

// T = O(n)
// S = O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        int[] map = new int[256];
        for(char c : p.toCharArray()) map[c]++;
        
        char[] sc = s.toCharArray();
        int L = 0, R = 0, unmatchedCnt = p.length();
        while(R < s.length()) {
            char rc = sc[R++];
            if(map[rc]-- > 0) unmatchedCnt--;
            if(unmatchedCnt != 0) continue;
            while(unmatchedCnt == 0) {
                char lc = sc[L++];
                if(map[lc]++ == 0) unmatchedCnt++; // **HIGHLIGHT if(map.get(lc) == 0) **
            }
            if(R-L+1 == p.length() && L-1 >= 0) res.add(L-1); 
        }
        return res;
    }
}