// T = O(n)
// S = O(1)
class Solution {
    String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            String key = "";
            for(char c : word.toCharArray()) key += map[c-'a'];
            set.add(code);
        }
        return set.size();
    }
}