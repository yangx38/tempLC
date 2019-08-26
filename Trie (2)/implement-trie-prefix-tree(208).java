// T = O(n*l)  n - # of words, l - ave word length
// S = O(n*l)
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) return false;
            cur = node;
        }
        return cur.isEnd;
    }

    // returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) return false;
            cur = node;
        }
        return true;
    }

    // delete word from trie
    public void delete(String word) {
        delete(root, word, 0);
    }
    
    private boolean delete(TrieNode cur, String word, int pos) {
        if(pos == word.length()) {
            if(!cur.isEnd) return false;
            cur.isEnd = false;
            return cur.children.size() == 0;
        }

        char c = word.charAt(pos);
        TrieNode node = cur.children.get(c);
        if(node == null) return false;
        boolean shouldDeleteCurrentNode = delete(node, word, pos+1);

        if(shouldDeleteCurrentNode) { 
            cur.children.remove(c);
            return cur.children.size() == 0;
        }
        return false;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        
        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}