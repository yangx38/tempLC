// T = O(m*n)
// S = O(m*n)
class Solution {
    int m, n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        m = matrix.length; n = matrix[0].length;
        int[][] checkP = new int[m][n], checkA = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            helper(matrix, checkP, i, 0);
            helper(matrix, checkA, i, n-1);
        }
        
        for(int i = 0; i < n; i++) {
            helper(matrix, checkP, 0, i);
            helper(matrix, checkA, m-1, i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(checkP[i][j] == 1 && checkA[i][j] == 1) {
                    List<Integer> subres = new ArrayList<>();
                    subres.add(i); subres.add(j);
                    res.add(subres);
                }
            }
        }
        return res;
    }
    
    private void helper(int[][] matrix, int[][] check, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        check[i][j] = 1;
        for(int[] d : dirs) {
            int newI = i+d[0], newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
            if(check[newI][newJ] == 1 || matrix[newI][newJ] < matrix[i][j]) continue;
            helper(matrix, check, newI, newJ);
        }
    }
}