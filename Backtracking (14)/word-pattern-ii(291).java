// T = O(n*n^m) dfs会进行m层, 答案总数是(n^m) 构造每个答案需要O(n)
    // m as the shorter's length; n as the longer's length
// S = O(n)
class Solution {
    Map<Character, String> map = new HashMap<>();
    Set<String> visitedWords = new HashSet<>();
    
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0) return false;
        return helper(pattern, 0, str, 0);
    }
    
    private boolean helper(String pattern, int i, String str, int j) {
        if(i == pattern.length() && j == str.length()) return true;
        if(i == pattern.length() || j == str.length()) return false;
        
        char c = pattern.charAt(i);
        if(map.containsKey(c)) {
            String word = map.get(c);
            if(!str.startsWith(word, j)) return false;
            return helper(pattern, i+1, str, j+word.length());
        }
        
        for(int k = j+1; k <= str.length(); k++) {
            String word = str.substring(j, k);
            if(visitedWords.contains(word)) return false;
            visitedWords.add(word);
            map.put(c, word);
            if(helper(pattern, i+1, str, k)) return true;
            map.remove(c);
            visitedWords.remove(word);
        }
        return false;
    }
}