// T = O(n*l) l as ave word length
// S = O(n*l) l as ave word length
class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) {
                node = new TrieNode();
                cur.children.put(c, node);
            }
            cur = node;
        }
        cur.isEnd = true;
    }
   
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                char[] wc = word.toCharArray();
                for(Character k : cur.children.keySet()) {
                    wc[i] = k;
                    if(search(new String(wc))) return true;
                }
                return false; // error
            } else {
                TrieNode node = cur.children.get(c);
                if(node == null) return false;
                cur = node;
            }
        }
        return cur.isEnd;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        
        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */