// T = O(n)
// S = O(1)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        if(s.length() < k) return s.length();
        char[] sc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        int L = 0, R = 0, res = 0;
        while(R < sc.length) {
            char rc = sc[R++];
            map.put(rc, map.getOrDefault(rc, 0)+1);
            while(map.size() > k) {
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
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        if(s.length() < k) return s.length();

        char[] sc = s.toCharArray();
        int[] map = new int[256];
        int L = 0, R = 0, res = 0, cnt = 0;
        while(R < sc.length) {
            char rc = sc[R++];
            if(map[rc]++ == 0) cnt++;
            while(cnt > k) {
                char lc = sc[L++];
                map[lc]--;
                if(map[lc] == 0) cnt--;
            }
            res = Math.max(res, R-L);
        }
        return res;
    }
}