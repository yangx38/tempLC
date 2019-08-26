// T = O(n*m) - n as strings.length, m as longest String length
// S = O(n)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            char[] sc = s.toCharArray();
            int start = sc[0]-'a';
            String key = "";
            for(int i = 0; i < s.length(); i++) {
                char c = (char)(sc[i]-start);
                if(c < 'a') c += 26;
                key += c;
            }
            
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}