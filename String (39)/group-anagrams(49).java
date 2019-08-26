// T = O(n*m) - n as strs length, m as longest Str in strs
// S = O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(Character ch : str.toCharArray()) count[ch-'a']++;
            String s = "";
            for(int i = 0; i < count.length; i++) {
                if(count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i+'a'));
                }
            }
            if(!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}