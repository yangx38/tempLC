// T = O(mn*4^L) 4^L for each cell b/c of the recursion
// S = O(L) w/ L len of word
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if(pos == word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        // explore
        boolean res = false;
        for(int[] d : dirs) {
            char c = board[i][j];
            board[i][j] = '#';
            res = dfs(board, word, i+d[0], j+d[1], pos+1);
            if(res) break;
            board[i][j] = c;
       }  
        return res;
    }
}