class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length; n = board[0].length;
        // first row, last row
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') helper(board, 0, i);
            if(board[m-1][i] == 'O') helper(board, m-1, i);
        }
        // first col, last col
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') helper(board, i, 0);
            if(board[i][n-1] == 'O') helper(board, i, n-1);
        }
        
        // mark in the end
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    private void helper(char[][] board, int i, int j) {
        // invalid
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(board[i][j] != 'O') return;
        // explore
        // mark as visited
        board[i][j] = '#';
        for(int[] d : dirs) {
            int newI = i+d[0], newJ = j+d[1];
            helper(board, newI, newJ);
        }
    }
}