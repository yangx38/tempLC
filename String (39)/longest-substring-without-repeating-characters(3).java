// T = O(n)
// S = O(1) only 26 letters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int L = 0, R = 0, res = 0;
        char[] sc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        while(R < sc.length) {
            char rc = sc[R++];
            map.put(rc, map.getOrDefault(rc, 0)+1);
            while(map.size() < (R-L)) {
                char lc = sc[L++];
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0) map.remove(lc);
            }
            res = Math.max(res, R-L);
        }
        return res;
    }
}

// T = O(n)
// S = O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int L = 0, R = 0, res = 0, cnt = 0;
        char[] sc = s.toCharArray();
        int[] map = new int[256];
        while(R < sc.length) {
            char rc = sc[R++];
            if(map[rc]++ == 0) cnt++;
            while(cnt < (R-L)) {
                char lc = sc[L++];
                map[lc]--;
                if(map[lc] == 0) cnt--;
            }
            res = Math.max(res, R-L);
        }
        return res;
    }
}