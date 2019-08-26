// T = O(n)
// S = O(1)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int L = 0, R = 0, res = 0;
        char[] sc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();  // freq map
        while(R < sc.length) {
            char rc = sc[R++];
            map.put(rc, map.getOrDefault(rc, 0)+1);
            while(map.size() > 2) {
                char lc = sc[L++];
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0) map.remove(lc);
            }
            res = Math.max(res, R-L);
        }
        return res;   
    }
}