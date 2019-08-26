// T = O(m*n)
// S = O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') matrix[i][j] = Integer.MAX_VALUE;
                else queue.offer(new int[]{i, j});
            }
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] oldIJ = queue.poll();
            int i = oldIJ[0], j = oldIJ[1];
            for(int[] d : dirs) {
                int newI = d[0]+i, newJ = d[1]+j;
                if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
                if(matrix[newI][newJ] <= matrix[i][j]+1) continue;
                queue.offer(new int[]{newI, newJ});
                matrix[newI][newJ] = matrix[i][j]+1;
            }
        }
        return matrix;
    }
}