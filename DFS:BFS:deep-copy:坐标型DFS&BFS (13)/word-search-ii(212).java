// 1. build TrieNode
// 2. buildTrie method according to words
// 3. DFS
class Solution {
    int m, n;
    List<String> res = new ArrayList<>();
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        m = board.length; n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, i, j);
            }
        }
        return res;
    }
    
    private void helper(char[][] board, TrieNode cur, int i, int j) {
        // valid case
        if(cur.isEnd != null) {
            res.add(cur.isEnd);
            cur.isEnd = null;
        }
        // invalid case
            // 越界, null, have visited
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        
        char c = board[i][j];
        if(c == '#') return;
        if(cur.children.get(c) == null) return;
        cur = cur.children.get(c);
        // explore
        for(int[] d : dirs) {
            board[i][j] = '#';
            helper(board, cur, i+d[0], j+d[1]);
            board[i][j] = c;
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            insert(root, word);
        }
        return root;
    }
    
    private void insert(TrieNode cur, String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) {
                node = new TrieNode();
                cur.children.put(c, node);
            }
            cur = node;
        }
        cur.isEnd = word;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        String isEnd;
        
        public TrieNode() {
            children = new HashMap<>();
            isEnd = null;
        }
    }
}