// T = O(n) - n as s length
// S = O(1)
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);

        char[] sc = s.toCharArray();
        int L = 0, R = 0, minLen = Integer.MAX_VALUE, start = 0, unmatchedCnt = t.length();
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
            if(R-L < minLen && L-1 >= 0) {
                minLen = R-L+1;
                start = L-1;
            } 
        }
        return minLen == Integer.MAX_VALUE? "": s.substring(start, start+minLen);
    }
}

// T = O(n) - n as s length
// S = O(1)
class Solution {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] map = new int[256];
        for(char c : t.toCharArray()) map[c]++;
        
        char[] sc = s.toCharArray();
        int L = 0, R = 0, minLen = Integer.MAX_VALUE, start = 0, unmatchedCnt = t.length();
        while(R < sc.length) {
            char rc = sc[R++];
            if(map[rc]-- > 0) unmatchedCnt--;
            if(unmatchedCnt != 0) continue;
            
            while(unmatchedCnt == 0) {
                char lc = sc[L++];
                if(map[lc]++ == 0) unmatchedCnt++;
            }
            if(R-L < minLen && L-1 >= 0) {
                minLen = R-L+1;
                start = L-1;
            } 
        }
        return minLen == Integer.MAX_VALUE? "": s.substring(start, start+minLen);
    }
}