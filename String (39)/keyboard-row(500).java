// T = O(n)
// S = O(n)
class Solution {
    String[] rows = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
    
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) return new String[0];

        int[] map = new int[256];
        for(int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for(char c : row.toCharArray()) {
                map[c] = i;
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String word : words) {
            char[] wc = word.toCharArray();
            int id = map[wc[0]];
            boolean valid = true;
            for(char c : wc) {
                if(map[c] != id) {
                    valid = false;
                    break;
                }
            }
            if(valid) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}