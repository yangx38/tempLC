// T = O(n) if no exist
// T = O(n!) if exists
// S = O(n)
class Solution {
    List<String> res = new ArrayList<>();
    boolean valid = true;
    String mid = "";
    List<Character> perm = new ArrayList<>();
    
    public List<String> generatePalindromes(String s) {
        if(s == null || s.length() == 0) return res;
        getPerm(s.toCharArray());
        if(!valid) return res;
        helper(new int[s.length()], new StringBuilder(), 0);
        return res;
    }
    
    private void getPerm(char[] sc) {
        int[] map = new int[256];
        for(int i = 0; i < sc.length; i++) map[sc[i]]++;
        int count = 0;
        for(int i = 0; i < map.length; i++) {
            if(map[i] % 2 != 0) {
                count++;
                mid = Character.toString((char)i);
            }
        }
        if(count > 1) {
            valid = false;
            return;
        }
        for(int i = 0; i < map.length; i++) {
            // need this line!!
            for(int j = 0; j < map[i]/2; j++) {
                perm.add((char)i);
            }
        }
    }
    
    private void helper(int[] visited, StringBuilder sb, int pos) {
        if(sb.length() == perm.size()) {
            res.add(sb.toString()+mid+sb.reverse().toString());
            sb.reverse();
            return;
        }
        for(int i = 0; i < perm.size(); i++) {
            if(visited[i] == 1) continue;
            if(i > 0 && perm.get(i) == perm.get(i-1) && visited[i-1] == 0) continue;
            sb.append(perm.get(i)); visited[i] = 1;
            helper(visited, sb, i+1);
            visited[i] = 0; sb.deleteCharAt(sb.length()-1);
        }
    }
}