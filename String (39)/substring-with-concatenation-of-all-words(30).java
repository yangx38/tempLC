// T = O(m*n) - m as s.length, n as words.length
// S = O(n)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null || words.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int n = words.length, m = words[0].length();
        
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i <= s.length() - n*m; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int k = 0, j = i;
            while(k < n) {
                String str = s.substring(j, j+m);
                if(!copy.containsKey(str) || copy.get(str) == 0) break;
                copy.put(str, copy.get(str)-1);
                k++;
                j += m;
            }
            if(k == n) res.add(i);
        }
        return res;
    }
}