// T = O(m*n)
// S = O(m*n)
class Solution {
    int m, n;
    int res = 0;
    int[][] visited;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(matrix, i, j);
            }
        }
        return res;
    }
    
    private int helper(int[][] matrix, int i, int j) {
        if(visited[i][j] != 0) return visited[i][j];
        int subres = 1;
        for(int[] d : dirs) {
            int newI = i+d[0], newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
            if(matrix[newI][newJ] <= matrix[i][j]) continue;
            subres = Math.max(subres, 1+helper(matrix, newI, newJ));
        }
        visited[i][j] = subres;
        res = Math.max(res, subres);
        return subres;
    }
}