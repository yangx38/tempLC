// T = O(n)
// S = O(n)
class Solution {
    public class ValidWordAbbr {
        Map<String, String> map = new HashMap<>();
        
        public ValidWordAbbr(String[] dictionary) {
            for(String dict : dictionary) {
                String abb = makeAbb(dict);
                if(map.containsKey(abb)) {
                    if(!map.get(abb).equals(dict)) map.put(abb, "");
                } else {
                    map.put(abb, dict);
                }
            }
        }
    
        public boolean isUnique(String word) {
            return !map.containsKey(makeAbb(word)) || map.get(makeAbb(word)).equals(word);
        }
    
        private String makeAbb(String s) {
            if(s.length() <= 2) return s;
            return s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
        }
    }
    
}