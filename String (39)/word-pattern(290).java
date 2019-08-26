// T = O(n)
// S = O(n)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) return false;
        String[] pc = str.split("\\s+");
        char[] sc = pattern.toCharArray();
        if(sc.length != pc.length) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < sc.length; i++) {
            if(!map.containsKey(sc[i])) map.put(sc[i], pc[i]);
            else {
                if(!map.get(sc[i]).equals(pc[i])) {
                    return false;
                }
            }
        }
        
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < sc.length; i++) {
            if(!map2.containsKey(pc[i])) map2.put(pc[i], sc[i]);
            else {
                if(!map2.get(pc[i]).equals(sc[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}